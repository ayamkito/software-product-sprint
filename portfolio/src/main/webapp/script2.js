async function displayFacts() {
    const serverRequest = await fetch("/funfacts");
    const messageFromServer = await serverRequest.json();


    const factsContainer = document.getElementById("funFacts");
    const NumberOfFacts = messageFromServer.length;
    const random = Math.floor(Math.random() * NumberOfFacts);
    factsContainer.innerText = "messageFromServer[random]";
    console.log("Display facts function")

}

//This function is meant to throw back at the user, only the date they entered.
// However, it is not yet polished as such. I am close to getting it but not yet.
async function contactInfo(){
    const datastoreRequest = await fetch("/contact-list");
    const datastoreResponse = await datastoreRequest.json();
    const contactContainer = document.getElementById("contact");

    contactContainer.innerText = "Information You Submitted" +"\n\n" + datastoreResponse[0]["name"] +"\n"+ datastoreResponse[0]["email"];
    console.log(datastoreResponse[0]);
}

// Create a page that list all that i have in my contact database
async function allDatabaseData(){
    fetch('/contact-list').then(response => response.json()).then((contact) => {
    const listContactsElement = document.getElementById('all-database-data');
    contact.forEach((contact) => {
      listContactsElement.appendChild(createContactElement(contact));
    })
  });

}

/** html elements for name and email*/
function createContactElement(contact) {
  const contactElement = document.createElement('div');
  contactElement.className = 'contact';

  const nameElement = document.createElement('div');
  nameElement.innerText = contact.name;

  const emailElement = document.createElement('address');
  emailElement.innerText = contact.email;

  contactElement.appendChild(nameElement);
  contactElement.appendChild(emailElement);
  return contactElement;
  console.log(contactElement);
}
