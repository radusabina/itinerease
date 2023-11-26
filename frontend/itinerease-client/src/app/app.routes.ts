import { HomepageComponent } from './homepage/homepage.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'homepage', component: HomepageComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'sigup', component: SignupComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { anchorScrolling: 'enabled' })],
    exports: [RouterModule],
})
export class AppRoutingModule {}
