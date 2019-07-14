window.onload = function(){
    //Richard Di Cosmo
    //1. Fibonnaci --------------------------------
    console.log("1. Fibonacci");
    console.log("Displays the Fibonacci sequence from 0-10.");
    //Loops through zero through ten
    for(let i = 0; i < 11; i++) {
        //displays the fibonacci number for each iteration of i
        console.log(fibonacci(i));
    };
    //2. Sort Array --------------------------------------
    console.log("");
    console.log("2. Sort Array of Integers");
    var arr = [2,4,5,1,3,1];
    console.log("Original Array: " + arr);
    console.log("After sort: " + sortArray(arr));
    //3. Factorial ------------------------------------
    let n = 7;
    console.log("");
    console.log("3. Factorial");
    console.log("Factorial of " + n + " equals: " + factorial(n));
    //4. Rotate Left ----------------------------------------
    console.log("");
    console.log("4. Rotate Left");
    arr = [1,2,3,4,5];
    n = 2;
    console.log("Original Array: " + arr);
    console.log("After rotating " + n + " times: " + rotateLeft(arr, n));
    //5. Balanced Brackets ----------------------------------------
    console.log("");
    console.log("5. Balanced Brackets");
    let test = "(((((";
    console.log(bracketTest(test));


}
//fibonacci sequence function
function fibonacci(n){
    //checks to see if the number is less than or equal to 1
    if(n <= 1){
        return n
    }
    return fibonacci(n-1) + fibonacci(n-2)
}
//sorting arrays function
function sortArray(arr){
    //loops through the array and moves higher numbers
    //to the right and lower numbers to the left
    //for loop with i iterates over the array 6 times
    for(let i=0; i < arr.length; i++){
        //inner loop iterates through the entire array once
        for(let j=0; j < arr.length; j++){
            if(arr[j] > arr[j+1]){
                let num1 = arr[j];
                let num2 = arr[j+1];
                arr[j] = num2;
                arr[j+1] = num1;
            }
        }
    }
    //returns the sorted array
    return arr;
}
//returns the factorial of any number
function factorial(n){
    var finalNum = n;
    //The for loop simulates the formula for factorial numbers.
    //For example: if 4 is inserted,
    //then 4x3x2x1=24
    for(let i = 1; i < n; i++){
        finalNum = finalNum*(n-i);
    }
    return finalNum;
}
//returns an array rotated n number of times to the left
function rotateLeft(arr, n){
    //first for loop specifies the number of times to rotate
    for(let i=0; i < n; i++){
        //second for loops moves all numbers up one
        for(let j=0; j < arr.length-1; j++){
                let num1 = arr[j];
                let num2 = arr[j+1];
                arr[j] = num2;
                arr[j+1] = num1;
        }
    }
    //returns the rotated array
    return arr;
}
function bracketTest(test){
   let checker = false;
    for(let i = 1; i < (test.length/2); i++){
        console.log(i + " vs " + (test.length-i));
        console.log(test.charAt(i) + " vs " + test.charAt(test.length-i));
        
            if(test.charAt(i - 1) == "("){
                if(test.charAt(test.length-i) == ")"){
                    checker = true;
                    
                }else {
                    return false;
                }
            }else if(test.charAt(i -1) == "["){
                if(test.charAt(test.length-i) == "]"){
                    checker = true;
                    
                }else{
                    return false;
                }
            }else if(test.charAt(i -1) == "{"){
                if(test.charAt(test.length-i) == "}"){
                    checker = true;
                    
                }else{
                    return false;
                }
            }else if(i = (test.length -1)){
                console.log(i + " vs " + (test.length-i));
                console.log(test.charAt(i) + " vs " + test.charAt(test.length-i));
                if(test.charAt(i - 1) == "("){
                    if(test.charAt(test.length-i) == ")"){
                        checker = true;
                        
                    }else {
                        return false;
                    }
                }else if(test.charAt(i -1) == "["){
                    if(test.charAt(test.length-i) == "]"){
                        checker = true;
                        
                    }else{
                        return false;
                    }
                }else if(test.charAt(i -1) == "{"){
                    if(test.charAt(test.length-i) == "}"){
                        checker = true;
                        
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }
    
    return checker;
}

