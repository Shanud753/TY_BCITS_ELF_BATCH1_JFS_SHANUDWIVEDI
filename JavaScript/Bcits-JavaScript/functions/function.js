function add(a, b) {
    var c = a + b;
    return c;
}
var sum = add(10, 20)
console.log('Sum is ', add(10, 20));
console.log('Sum is ', sum);
console.log('=========================================================');

var n1 = 10;
var str = '10';
if (n1 === str) {
    console.log('Equal');

} else {
    console.log('Not Equal');

}
console.log('=========================================================');
console.log(typeof null);
console.log(typeof(undefined));
typeof

function add(a, b) {

}
console.log(typeof add);

var a = [10, 20, 30];
console.log(typeof a);
console.log(Array.isArray(a));
var isAry = Array.isArray(a);
if (isAry == true) {
    console.log('a is an array');
} else {
    console.log('a is not an array');
}
console.log('=========================================================');

var addM = (a, b) => a + b;
var s = addM(10, 20);
console.log('Sum ', s);

var sqr = a => a * a;
var n = sqr(20)
console.log(`Square is ${n}`);
console.log(`Square of 10 ${10*10}`);