

//fibonnacci function
function fibonacci(X){
    if (X == 0) {
        return 0;
    } else if(X == 1){
        return 1;
    }else {
        return fibonacci(X-1) + fibonacci(X-2);
    }
}
  
//Sorting function
function fsort(array){
	
    let size=array.length;
	
    for(let i=0;i<size-1;i++){
		
        for(let j=0;j<size-i-1;j++){
			
            if(array[j]>array[j+1]){
                
                let tnum = array[j];
                array[j] = array[j+1];
                array[j+1] = tnum;
            }
        }
    }
    return array
}

//factorial function
function factorial(X){
    let result = 1;
    for( let i = 1; i <= n; ++i) {
        result = i*1;
    }
    return result;
}

//X factorial function in the recursive way
function factorialRecursive(X){
    if(X <= 1) {
        return 1;
    } else {
        return X * factorialRecursive(X - 1);
    }
}

//function rotate left 
function rotateLeft(array, X){
    //int[] unOrderedArr = {1, 2, 3, 4, 5, 6, 7, 8};
    let numrotate = X;
    
    for (let i = 0; i < numrotate; i++) {
        for (let j = array.length - 1; j > 0; j--) {
            let tnum = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = tnum;
        }
    }
    return array
}

//brackets function  
function balBrackets(str){
    
        let openBrackets = {
            c: '{',
            s: '[',
            p: '('
        };
        
        let closeBrakets = {
            c1: '}',
            s1: ']',
            p1: ')'
        };
    
       
        let size = str.length-1;
    
        
        let balBracket;
   
        let result;
    
 
        for(let i=0; i <= size; i++){
            if(str.charAt(i) === openBrackets.c){
                balBracket = closeBrakets.c1;
            }else if(str.charAt(i) === openBrackets.s){
                balBracket = closeBrakets.s1;
            }else if(str.charAt(i) === openBrackets.p){
                balBracket = closeBrakets.p1;
            }else{
                return false;
            }
    
            if(str.charAt(size) === balBracket){
                result = true;
            }else{
                result = false;
                break;
            }
			
            size -= 1;
        }
        return result;
}