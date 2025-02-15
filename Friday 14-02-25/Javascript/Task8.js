let prices = {
    Monday: 40,
    Tuesday: 55,
    Wednesday: 60,
    Thursday: 45,
    Friday: 50,
    Saturday: 60,
    Sunday: 50
};
let totalPrice = 0;
let daysCount = 0;
for (let day in prices) {
    totalPrice += prices[day];
    daysCount++;
}
let avgPrice = totalPrice / daysCount;
if (avgPrice > 50) {
    console.log("Tomato has given good profit.");
} else {
    console.log("No profit from tomato.");
}
