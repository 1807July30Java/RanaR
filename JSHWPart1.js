var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

  if(n === 0){
    return 0;
  }

  else if(n === 1 || n === 2){
    return 1;
  }

  else{
    var fib = 0;
    var fibOfTwoNumsDown = 1;
    var fibOfOneNumDown = 1;
    for(var i = 3; i <= n; i++){
      fib = fibOfTwoNumsDown + fibOfOneNumDown;

      fibOfTwoNumsDown = fibOfOneNumDown;
      fibOfOneNumDown = fib;
    }
    return fib;
  }

};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
  var temp;
  for(var  i = 0; i < array.length; i++){
    for(var j = i+1; j < array.length; j++){
      if(array[i] > array[j]){
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
  }
  return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
  var factorial = 1;
  for(var i = n; i > 0; i--){
    factorial *= i;
  }
  return factorial;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
  var firstItemOfArray;
  for(var i = 0; i < n; i++){
    firstItemOfArray = array.shift();
    array.push(firstItemOfArray);
  }

  return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){

  var balancedBracketsStack = [];

  for(var i = 0; i < bracketsString.length; i++){
    if(bracketsString[i] === "("){
      balancedBracketsStack.push(bracketsString[i]);
    }
    else if(bracketsString[i] === "{"){
      balancedBracketsStack.push(bracketsString[i]);
    }
    else if(bracketsString[i] === "["){
      balancedBracketsStack.push(bracketsString[i]);
    }
    else if(bracketsString[i] === ")" && balancedBracketsStack[balancedBracketsStack.length-1] === "("){
      balancedBracketsStack.pop();
    }
    else if(bracketsString[i] === "}" && balancedBracketsStack[balancedBracketsStack.length-1] === "{"){
      balancedBracketsStack.pop();
    }
    else if(bracketsString[i] === "]" && balancedBracketsStack[balancedBracketsStack.length-1] === "["){
      balancedBracketsStack.pop();
    }
  }

  if(balancedBracketsStack.length === 0){
      return true;
    }
  else{
      return false;
  }
};
