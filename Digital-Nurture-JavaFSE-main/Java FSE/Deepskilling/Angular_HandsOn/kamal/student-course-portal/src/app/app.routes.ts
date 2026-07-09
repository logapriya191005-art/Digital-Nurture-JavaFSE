import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { CourseListComponent } from './pages/course-list/course-list';
import { StudentProfile } from './pages/student-profile/student-profile';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { CourseDetail } from './pages/course-detail/course-detail';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'courses/:id', component: CourseDetail },
  { path: 'profile', component: StudentProfile },
  { path: 'enroll', component: EnrollmentForm },
  { path: '**', redirectTo: '' }
];