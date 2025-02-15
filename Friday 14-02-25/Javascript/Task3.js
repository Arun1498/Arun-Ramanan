const c = 20;
function isPrime(n) {
    if (n <= 1) return console.log(n + " is Not Prime");
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return console.log(n + " is Not Prime");
    }
    console.log(n + " is Prime");
}
isPrime(c);
