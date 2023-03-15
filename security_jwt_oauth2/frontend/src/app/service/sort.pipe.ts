import { Pipe, PipeTransform } from '@angular/core';
import {Product} from "../model/product";

@Pipe({
  name: 'sort'
})
export class SortPipe implements PipeTransform {

  transform(value: Product[], condition: string, prop: string): any {
    if (condition === 'asc') {
      return value.sort((a, b) => {
        // @ts-ignore
        if (a[prop] > b[prop]) return 1
        // @ts-ignore
        if (a[prop] < b[prop]) return -1
        return 0
      });
    } else if (condition === 'desc') {
      return value.sort((a, b) => {
        // @ts-ignore
        if (a[prop] > b[prop]) return -1
        // @ts-ignore
        if (a[prop] < b[prop]) return 1
        return 0
      });
    } else if (condition === '' || prop === '') {
      return value.sort((a, b) => {
        // @ts-ignore
        if (a['id'] > b['id']) return 1
        // @ts-ignore
        if (a['id'] < b['id']) return -1
        return 0
      })
    }
  }

}
