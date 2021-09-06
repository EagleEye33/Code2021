function reverseArray(array) {
    let newArray = [];
    for (i = 0; i < array.length; i++) {
        newArray.push(array[array.length-(i+1)])
    }
    return newArray;
}

function reverseArrayInPlace(array) {
    for (i = 0; i < Math.floor(array.length / 2); i++) {
        let j = array[i];
        array[i] = array[array.length-(i+1)];
        array[array.length-(i+1)] = j;
    }
    return array
}

console.log(reverseArray(["A", "B", "C"]));
// → ["C", "B", "A"];
let arrayValue = [1, 2, 3, 4, 5];
reverseArrayInPlace(arrayValue);
console.log(arrayValue);
// → [5, 4, 3, 2, 1]