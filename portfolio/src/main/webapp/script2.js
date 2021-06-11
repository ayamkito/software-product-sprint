async function displayFacts(){
const serverRequest = await fetch("/funfacts");
const messageFromServer = await serverRequest.json();


const factsContainer = document.getElementById("funFacts");
    const NumberOfFacts = messageFromServer.length;
    const random = Math.floor(Math.random()* NumberOfFacts);
    factsContainer.innerText = messageFromServer[random];

}