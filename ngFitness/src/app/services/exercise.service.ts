import { Exercise } from '../models/exercise';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { toUnicode } from 'punycode';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {
private baseUrl = 'http://localhost:8085/';
private url = this.baseUrl + 'api/exercise';


  constructor(
    private http: HttpClient
    ) { }

    index(): Observable<Exercise[]>{
      return this.http.get<Exercise[]>(this.url + '?sorted=true').pipe(
        catchError((err:any)=>{
        console.log(err);
        return throwError('ExerciseService.index(): error');

        })
      );
    }

    show(exId: number){
      return this.http.get<Exercise>(this.url + '/' + exId
      + '?sorted=true').pipe(
        catchError((err:any)=>{
        console.log(err);
        return throwError('ExerciseService.show(): error');
      })
      );
    }

    create(newExercise: Exercise){
      return this.http.post<Exercise>(this.url, newExercise).pipe(
        catchError((err:any)=>{
        console.log(err);
        return throwError('ExerciseService.create(): error');
      })
      );
    }

    update(exId: number, exercise: Exercise){
      return this.http.put<Exercise>(this.url + '/' + exId, exercise).pipe(
        catchError((err:any)=>{
        console.log(err);
        return throwError('ExerciseService.update(): error');
      })
      );
    }
    delete(exId: number){
      return this.http.delete<Exercise>(this.url + '/' + exId).pipe(
        catchError((err:any)=>{
        console.log(err);
        return throwError('ExerciseService.delete(): error');
      })
      );
    }

}
