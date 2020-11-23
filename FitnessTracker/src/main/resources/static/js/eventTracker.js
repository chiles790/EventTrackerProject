window.addEventListener("load", function () {
  console.log("Script loaded");

  init();
});

function init() {
  console.log("in init() still");
  document.fitnessForm.lookup.addEventListener("click", function (event) {
    event.preventDefault();
    var exId = document.fitnessForm.exId.value;
    if (!isNaN(exId) && exId > 0) {
      getExercise(exId);
    }
  });
  document.newExerciseForm.submit.addEventListener("click", function (ev) {
    ev.preventDefault();
    postNewExercise(ev);
  });

//   document.updateExerciseForm.updateExercise.addEventListener(
//     "click",
//     function (ev) {
//       e.preventDefault();
//       let exId = document.updateExerciseForm.exId.value;
//       updateExercise(exId);
//     }
//   );

//   document.deleteExerciseForm.deleteExercise.addEventListener(
//     "click",
//     function (ev) {
//       e.preventDefault();
//       let exId = document.deleteExerciseForm.exId.value;
//       deleteExercise(exId);
//     }
//   );

  //TODO: setup event listeners for buttons etc.
}
function getExercise(exId) {
  console.log("getExercise(): exId=" + exId);

  let xhr = new XMLHttpRequest();
  //xhr.open('PUT', 'api/fitness/' + fitnessId);
  xhr.open("GET", "api/exercise/" + exId);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let exercise = JSON.parse(xhr.responseText);
        console.log(xhr.responseText);
        console.log(exercise);
        displayExercise(exercise);
      } else {
        console.error("Exercise not found.");
        displayError("Exercise not found.");
      }
    }
  };
  xhr.send();
}
function displayError(msg) {
  let div = document.getElementById("fitnessData");
  div.textContent = msg;
}
function displayExercise(exercise) {
  var dataDiv = document.getElementById("fitnessData");
  dataDiv.textContent = "";
  let h1 = document.createElement("h1");
  h1.textContent = exercise.name;
  dataDiv.appendChild(h1);
  let bq = document.createElement("blockquote");
  bq.textContent = exercise.description;
  dataDiv.appendChild(bq);
  let ul = document.createElement("ul");
  let li = document.createElement("li");
  li.textContent = exercise.averageCaloriesPerHour;
  ul.appendChild(li);
  li = document.createElement("li");
  li.textContent = exercise.comments;
  ul.appendChild(li);
  li = document.createElement("li");
  li.textContent = exercise.typeOfExercise;
  ul.appendChild(li);
  dataDiv.appendChild(ul);
//   btn.innerHTML = 'Update Exercise';
//   btn.addEventListener('click', function(e){
//       e.preventDefault();
//       exerciseStats(exercise);
//       document.updateExerciseForm.name.focus();
//   });
//   dataDiv.appendChild(btn);

  document.updateExerciseForm.updatedExercise.addEventListener('click', function(e){
      e.preventDefault();
      updatedExercise();
  });
  document.deleteExerciseForm.deleteExercise.addEventListener("click",function (e) {
          e.preventDefault();
          deleteExercise(exId);
        });
}

function postNewExercise(e) {
  let form = document.newExerciseForm;
  let newExercise = {
    name: form.name.value,
    description: form.description.value,
    averageCaloriesPerHour: form.averageCaloriesPerHour.value,
    comments: form.comments.value,
    typeOfExercise: form.typeOfExercise.value,
  };
  console.log(newExercise);
  let xhr = new XMLHttpRequest();
  xhr.open("POST", "api/exercise");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 201 || xhr.status === 200) {
        let savedExercise = JSON.parse(xhr.responseText);
        displayExercise(savedExercise);
      } else {
        console.error("Error creating Exercise, status=" + xhr.status);
        console.error(xhr.responseText);
        displayError("Invalid Exercise");
      }
    }
  };
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send(JSON.stringify(newExercise));
}

function updatedExercise(){
    let form = document.newExerciseForm;
    let newExercise = {
      name: form.name.value,
      description: form.description.value,
      averageCaloriesPerHour: form.averageCaloriesPerHour.value,
      comments: form.comments.value,
      typeOfExercise: form.typeOfExercise.value,
    };
    xhr.open("PUT", "api/exercise/" + exId);
    exhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status ===200){
                let updatedExercise = JSON.parse(xhr.responseText);
                displayExercise(updatedExercise);
            }
        }
    };
}

function deleteExercise(exId) {
  let xhr = new XMLHttpRequest();
  xhr.open("DELETE", "api/exercise/" + exId);
  exh.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 204) {
          let div = document.getElementById('fitnessData');
          div.textContent = '';
          let deleted = document.createElement('h2')
          deleted.textContent = 'Exercise has been deleted';
        div.appendChild(deleted);
                init();
      } else {
        console.error("Error deleting Exercise, status=" + xhr.status);
    div.textContent = 'Error deleting Exercise';  
    }
    }
  };
  xhr.send(null);
}
// xhr.send)JSON.stringify(updatedFitness));
//xhr.open('DELETE', 'api/fitness/' + fitnessId);