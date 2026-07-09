import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  isLoading = true;
  selectedCourseId: number | null = null;
  
  courses = [
    { id: 1, name: 'Angular Basics', code: 'ANG101', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'React Advanced', code: 'REA201', credits: 4, gradeStatus: 'pending' },
    { id: 3, name: 'Node.js API', code: 'NOD102', credits: 2, gradeStatus: 'failed' },
    { id: 4, name: 'Python Data Science', code: 'PYT202', credits: 4, gradeStatus: 'passed' },
    { id: 5, name: 'Java Microservices', code: 'JAV301', credits: 5, gradeStatus: 'pending' }
  ];

  ngOnInit() {
    setTimeout(() => { this.isLoading = false; }, 1500);
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}