console.log("Problem 1");

function min() {
  var result = Infinity;
  for(var i = 0; i < arguments.length; i++) {
    if(arguments[i] < result) {
      result = arguments[i];
    }
  }

  if(result == Infinity){
    result = null;
  }
  return result;
}


console.log(min(10 , 5, 8, 21));
console.log(min());





console.log("Problem 2");

function P2(){
  var result = " ";

  for(var i = 0; i < 7; i++){
    result = result + "#";
    console.log(result);
  }
}

P2();




console.log("Problem 3");

function countBs(word){
    var counter = 0;

    for(var i = 0; i < word.length; i++){
      if(word.charAt(i) == "B") {
        counter++;
      }
    }

    return counter;
}


function countChar(word, char){
  var counter = 0;

  for(var i = 0; i < word.length; i++){
    if(word.charAt(i) == char) {
      counter++;
    }
  }

  return counter;
}




console.log(countBs("BBBbbbbDBJkjh"));
console.log(countChar("ghhhsssjjfggjsje", "g"));









console.log("Problem 4");


function reverseArray(array){
  var newArray = new Array;

  for(var i = array.length - 1; i >= 0; i--){
    newArray.push(array[i]);
  }
  return newArray;
}



function reverseArrayInPlace(array){
  var i = 0;
      var j = array.length - 1;
      while (i < j) {
          var x = array[i];
          array[i] = array[j];
          array[j] = x;
          i++;
          j--;
      }
  return array;
}



console.log(reverseArray(["A", "B", "C"]));

var arrayValue = [1, 2, 3, 4, 5];
reverseArrayInPlace(arrayValue);
console.log(arrayValue);







console.log("Problem 5");

function deepEqual(val1, val2){
  if((typeof val1 == "object" && val1 != null) && (typeof val2 == "object" && val2 != null)) {
    if(Object.keys(val1).lenght != Object.keys(val2).lenght){
      return false;
    }

    for (var prop in val1) {
      if (val2.hasOwnProperty(prop))
      {
        if (! deepEqual(val1[prop], val2[prop]))
          return false;
      }
      else
        return false;
    }

    return true;
  }
  else if (val1 !== val2)
    return false;
  else
    return true;
}

var obj = {here: {is: "an"}, object: 2};
console.log(deepEqual(obj, obj));

console.log(deepEqual(obj, {here: 1, object: 2}));

console.log(deepEqual(obj, {here: {is: "an"}, object: 2}));
