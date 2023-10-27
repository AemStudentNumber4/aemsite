document.addEventListener("DOMContentLoaded", function() {
  myFunction();
});

function myFunction() {

  var textContainer = document.querySelector(".text-container");
  console.log(textContainer);
  var shouldModify = textContainer.dataset.shouldModify;
  console.log(shouldModify);

  if(shouldModify) {
    console.log('Modify');
    var paragraph = textContainer.querySelector("p");
    console.log(paragraph);
    var text = paragraph.textContent;
    console.log(text);
    var updatedText = text.replace(/positive/g, 'Alladin');
    console.log(updatedText);
    paragraph.textContent = updatedText;
  }
}
