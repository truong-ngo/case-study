import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Category} from "../../model/category";

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit{
  category?: Category;
  editMode: Boolean = false;
  editId?: number;
  categoryForm = new FormGroup({
    name: new FormControl(null),
  })

  constructor(private categoryService: CategoryService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.editMode = !!params['id']
        if (this.editMode) {
          this.editId = +params['id']
          this.initForm()
        }
      }
    )
  }

  initForm() {
    if (this.editMode) {
      this.categoryService.getCategory(this.editId).subscribe(
        data => {
          // @ts-ignore
          this.categoryForm.patchValue(data);
        }
      )
    }
  }

  onSubmit() {
    this.category = this.categoryForm.value as Category
    if (this.editMode) {
      this.category.id = this.editId;
      this.categoryService.editCategory(this.category).subscribe(
        () => {
          this.handleSubmit()
        }
      )
    } else {
      this.categoryService.addCategory(this.category).subscribe(
        () => {
          this.handleSubmit()
        }
      )
    }
  }

  handleSubmit() {
    this.router.navigate(['/categories'])
    this.categoryService.getCategories().subscribe(
      data => {
        this.categoryService.categoriesChange.next(data);
      }
    )
  }
}
