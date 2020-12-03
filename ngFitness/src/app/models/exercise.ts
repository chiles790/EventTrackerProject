export class Exercise {
exId: number;
name: string;
description: string;
averageCaloriesPerHour: number;
comments: string;
typeOfExercise: string;

constructor(
exId?: number,
name?: string,
description?: string,
averageCaloriesPerHour?: number,
comments?: string,
typeOfExercise?: string
){
this.exId = exId;
this.name = name;
this.description = description;
this.averageCaloriesPerHour = averageCaloriesPerHour;
this.comments = comments;
this.typeOfExercise = typeOfExercise;
}
}
