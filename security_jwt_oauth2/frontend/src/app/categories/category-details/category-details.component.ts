import {Component, OnInit} from '@angular/core';
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {
  category?: Category

  constructor(private categoryService: CategoryService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.handleCategoryGet(+params['id'])
      }
    )
  }

  handleCategoryGet(id: number) {
    this.categoryService.getCategory(id).subscribe(
      data => {
        this.category = data
      }
    )
  }

}
