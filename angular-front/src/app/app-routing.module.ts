import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TestComponent} from "./test/test.component";
import {QuestionComponent} from "./question/question.component";
import {LoginComponent} from "./login/login.component";
import {TestsComponent} from "./tests/tests.component";

const routes: Routes = [
  {path: 'test', component: TestComponent},
  {path: 'tests', component: TestsComponent},
  {path: 'question', component: QuestionComponent},
  {path: 'login', component: LoginComponent},

  {path:'**', redirectTo:'/tests'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
