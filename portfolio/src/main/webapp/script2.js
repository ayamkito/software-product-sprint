async function displayFacts(){
const serverRequest = await fetch("/funfacts");
const messageFromServer = await serverRequest.text();

const factsContainer = document.getElementById("funFacts");
factsContainer.innerText = messageFromServer;

}