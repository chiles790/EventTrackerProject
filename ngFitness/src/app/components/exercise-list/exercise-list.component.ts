import { Exercise } from './../../models/exercise';
import { ExerciseService } from './../../services/exercise.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-exercise-list',
  templateUrl: './exercise-list.component.html',
  styleUrls: ['./exercise-list.component.css']
})
export class ExerciseListComponent implements OnInit {

  constructor( private exerciseService: ExerciseService) { }

  exercises: Exercise[] = [];
  selected: Exercise = null;
  newExercise: Exercise = new Exercise();
  updated: boolean = false;
  add: boolean = false;
  ngOnInit(): void {
    this.index();
  }

  create(): void{
    this.exerciseService.create(this.newExercise).subscribe(
    good=>{
      this.newExercise = good;
      console.log('received');
    },
    error=>{
      console.error('received failed');
      console.error(error);
    }
    );
  }
  index(): void{
    this.exerciseService.index().subscribe(
      good=>{
        this.exercises = good;
      },
      error=>{
        console.error('failed to load index()');
        console.error(error);
      }
    );
  }
  update(): void{
    this.exerciseService.update(this.selected.exId, this.selected).subscribe(
    good=>{
      this.newExercise = good;
      console.log('updated exercise received');
    },
    error=>{
      console.error('failed to update exercise');
      console.error(error);
    }
    );
  }

  delete(): void{
    this.exerciseService.delete(this.selected.exId).subscribe(
      good=>{
        this.selected = good;
        console.log('Successfully deleted exercise');

      },
      error=>{
        console.error('failed to delete exercise');
        console.error(error);


      }
    );
  }

  show(): void{
    this.exerciseService.show(this.selected.exId).subscribe(
      good=>{
        this.selected = good;
        console.log('exercise selected');
      },
      error=>{
        console.error('failed to select exercise');
        console.error(error);

      }
    );
  }

}
