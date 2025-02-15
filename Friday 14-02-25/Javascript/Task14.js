let start = 10;
let end = 40;

for (let num = start; num <= end; num++) {
  console.log(num);
  if (num % 7 === 0) {
    break;
  }
}
