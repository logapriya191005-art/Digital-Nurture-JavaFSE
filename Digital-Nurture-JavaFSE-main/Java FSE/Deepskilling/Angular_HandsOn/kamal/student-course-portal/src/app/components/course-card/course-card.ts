import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { NgIf, NgClass, NgStyle, NgSwitch, NgSwitchCase, NgSwitchDefault } from '@angular/common';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [NgIf, NgClass, NgStyle, NgSwitch, NgSwitchCase, NgSwitchDefault],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course: any;
  @Output() enrollRequested = new EventEmitter<number>();
  isExpanded = false;

  ngOnChanges(changes: SimpleChanges) {
    if (changes['course']) {
      console.log('Previous value:', changes['course'].previousValue);
      console.log('Current value:', changes['course'].currentValue);
    }
  }

  get cardClasses() {
    return {
      'card-full': this.course && this.course.credits >= 4
    };
  }

  get borderStyle() {
    if (!this.course) return {};
    const color = this.course.gradeStatus === 'passed' ? 'green' : 
                  this.course.gradeStatus === 'failed' ? 'red' : 'grey';
    return { 'border-left': `5px solid ${color}` };
  }

  onEnroll() {
    this.enrollRequested.emit(this.course.id);
  }

  toggleDetails() {
    this.isExpanded = !this.isExpanded;
  }
}