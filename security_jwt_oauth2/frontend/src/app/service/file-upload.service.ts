import {Injectable} from "@angular/core";
import {AngularFireDatabase} from "@angular/fire/compat/database";
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {finalize, Observable} from "rxjs";
import * as url from "url";

@Injectable()
export class FileUploadService {
  constructor(private uploadDB: AngularFireDatabase,
              private storage: AngularFireStorage) {
  }

  pushFileToStorage(baseUrl: string, file: File): Observable<string> {
    const filePath = `${baseUrl}/${file.name.split('.').slice(0, -1).join('.')}_${new Date().getTime()}`
    const fileRef = this.storage.ref(filePath)
    const uploadTask = this.storage.upload(filePath, file)
    return new Observable(observer => {
      uploadTask.snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(url => {
            observer.next(url)
            observer.complete()
          })
        })
      ).subscribe()
    })
  }
}
