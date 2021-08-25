

let navRow= document.getElementById("mainNavLeft");

let height = navRow.offsetHeight;

let heightToInsert = height - (height * 0.15);

navRow.style.transform = `translateY(-${heightToInsert}px)`;


