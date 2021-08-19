const submitButton = document.getElementById('submitButton');
let storedAds = [];
const storedAdsDiv = document.getElementById('currentAdsDiv');


submitButton.addEventListener('click', () => {
        let pageLocation = document.getElementById('pageLocationInput').value;
        let adTagUrl = document.getElementById('adTagUrl').value;
        let columnPositionA = document.getElementById('columnAInput').value;
        let columnPositionB = document.getElementById('columnBInput').value;
        let columnPositionC = document.getElementById('columnCInput').value;


        let newMedia = {
            adTagUrl: adTagUrl,
            pageTitle: pageLocation,
            columnPositionA: columnPositionA,
            columnPositionB: columnPositionB,
            columnPositionC: columnPositionC
        }

        fetch("http://localhost:8080/add-media", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",

            },
            body: JSON.stringify(newMedia),
        }).then(response => console.log(response));

        fetch('/fetch-all-media').then(data => data.json()).then(data => {
            console.log(data) ;
            storedAds.push(data);
        }).then(() => console.log(storedAds)).then(() => { displayMedia(storedAds[0])});



function displayMedia(mediaList) {
    mediaList.forEach(media => {
        let mediaPage = document.createElement('h2');
        mediaPage.innerText = media.adTagUrl;
        storedAdsDiv.appendChild(mediaPage);
    })
}

    }
)


