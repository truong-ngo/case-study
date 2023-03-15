import {Component, OnInit} from '@angular/core';
import {Category} from "../model/category";
import {CategoryService} from "../service/category.service";
import {faPenToSquare, faTrash} from "@fortawesome/free-solid-svg-icons";
import Swal from "sweetalert2";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  categories?: Category[]
  editIcon = faPenToSquare
  deleteIcon = faTrash

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.categories = this.categoryService.categories
    this.categoryService.categoriesChange.subscribe(
      data => {
        this.categories = data
      }
    )
  }

  deleteCategories(c: Category) {
    Swal.fire({
      title: 'Are you sure want to remove?',
      text: 'You will not be able to recover this category!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.value) {
        this.categoryService.deleteCategory(c.id).subscribe(
          () => {
            Swal.fire(
              'Deleted!',
              'Category has been deleted',
              'success'
            )
            this.handleDelete()
          }
        )
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          '',
          'error'
        )
      }
    })
  }

  handleDelete() {
    this.categoryService.getCategories().subscribe(
      data => {
        this.categoryService.categoriesChange.next(data);
      }
    )
  }
}
