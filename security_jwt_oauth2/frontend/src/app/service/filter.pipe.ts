import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  constructor() {
  }
  transform<T, U>(value: T[], name: U): any {
    if (name === '') {
      return value
    }

    const a = value.filter(
      (v) => {
        // @ts-ignore
        let c = v['category']
        // @ts-ignore
        return c['name'] === name
      }
    )
    console.log(a)
    return a
  }

}
