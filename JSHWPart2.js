/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA(){
  var elements = document.querySelectorAll( 'body *' );
  var usaElement;
  for(var i = 0; i < elements.length; i++){
    if(elements[i].textContent === "USA"){
      usaElement = elements[i];
      break;
    }
  }
  return(usaElement.innerText);
};
/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales(){

  var table = document.getElementsByTagName("table");
  var names = [];
  for (var i = 1; i < table[0].rows.length; i++) {
      var name = (table[0].rows[i].cells[0].textContent.trim());
      var dept = (table[0].rows[i].cells[1].textContent.trim());
      if(dept === "Sales"){
        names.push(name);
      }
  }
  return names;
};

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
function getAnchorChildren(){
  var anchor = document.getElementsByTagName("a");
  var spanContent = [];
  for(var i = 0; i < anchor.length; i++){
    if(anchor[i].children.length != 0){
      for(var j = 0; j < anchor[i].children.length; j++){
        if(anchor[i].children[j].localName === "span"){
          spanContent.push(anchor[i].children[j].innerText);
        }
      }
    }
  }
  return spanContent;
};

/*
4. Hobbies
Define function getSkills()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
function getSkills(){
  var skills = document.getElementsByName("skills");
  for(var i = 0; i < skills.length; i++){
    for(var j = 0; j < skills[i].options.length; j++){
      if(skills[i].options[j].selected){
        console.log("Value: " + skills[i].options[j].value + " Contents: " + skills[i].options[j].innerText);
      }
    }
  }
};

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function getCustomAttribute(){
  var element = document.querySelectorAll( 'body *' );
  for(var i = 0; i < element.length; i++){
    if(element[i].attributes.length != 0){
      for(var j = 0; j < element[i].attributes.length; j++){
        if(element[i].attributes[j].name === "data-customattr"){
          console.log("Value of attribute: " + element[i].attributes[j].value +
            "\nElement with attribute data-customAttr: " + element[i].localName);
        }
      }
    }
  }
};

/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
<input id="num1" class="nums" type="text"/>
<input id="num2" class="nums" type="text"/>
<h3>Sum: span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/
function sumEvent(){
  var num1 = document.getElementById("num1");
  var num2 = document.getElementById("num2");
  var sumSpan = document.getElementById("sum");
  var numsSum = 0;

  num2.onchange = function(){
    numsSum = parseInt(num1.value, 10) + parseInt(num2.value, 10);

    if(numsSum){
      sumSpan.innerText = numsSum;
    }
    else{
      sumSpan.innerText = "Cannot add.";
    }
  };
};
sumEvent();
/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/
function selectskill(){

  var skills = document.getElementsByName("skills");
  var skillOptions = skills[0];

  skillOptions.onchange = function(){
    var selectedSkill = skillOptions.selectedIndex;
    var skillName;
    if(selectedSkill === 0){
      skillName = skillOptions[0].innerText;
      alert("You think you're skilled in " + skillName + "? Ha. Don't make me laugh.");
    }
    else if(selectedSkill === 1){
      skillName = skillOptions[1].innerText;
      alert("My grandma writes better " + skillName + " code than you.");
    }
    else if(selectedSkill === 2){
      skillName = skillOptions[2].innerText;
      alert("Since when is knowing " + skillName + " a skill?");
    }
    else if(selectedSkill === 3){
      skillName = skillOptions[3].innerText;
      alert("Look guys, this person is skilled in " + skillName + ". See? Nobody cares.");
    }
    else if(selectedSkill === 4){
      skillName = skillOptions[4].innerText;
      alert("Finally a person skilled in " + skillName + ". Now move this div by 2px please.");
    }
    else if(selectedSkill === 5){
      skillName = skillOptions[5].innerText;
      alert("Java, JavaScript. What's the difference?");
    }
  };
};
selectskill();

/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons)
the newly selected favoriteColor
*/
function favoriteColorEvent(){
  var favoriteColors = document.getElementsByName("favoriteColor");
    for(var i = 0; i < favoriteColors.length; i++) {
      favoriteColors[i].onchange = function(){
        alert("So you like " + this.value + " more than " + this.style.backgroundColor + " now?");
        for(var j = 0; j < favoriteColors.length; j++) {
          favoriteColors[j].style.backgroundColor = this.value;
        }
      };
    }
};
favoriteColorEvent();

/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
Hide the name if shown.
Show the name if hidden.
*/
function hideEmployeeName(){
  var employees = document.getElementsByClassName("empName");
  for(var i = 0; i < employees.length; i++){
    employees[i].onmouseover = function(){
      if(this.style.color === "white"){
        this.style.color = "black";
      }
      else{
        this.style.color = "white";
      }
    }
    employees[i].onmouseleave = function(){
      if(this.style.color === "white"){
        this.style.color = "black";
      }
      else{
        this.style.color = "white";
      }
    }
  }
};
hideEmployeeName();

/*
10. Current Time
Regarding this element:
  <h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
function currentTime(){
  var time = setInterval(function(){
    var timeHeader = document.getElementById("currentTime");
    var currTime = new Date(Date.now());
    timeHeader.innerText = currTime.toLocaleString();
  }, 1000);
};
window.onload = function(){
    currentTime();
};

/*
11. Delay
Regarding this element:
<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
function delayColorChange(){
  var redVal, greenVal, blueVal;
  var helloWorld = document.getElementById("helloWorld");
  helloWorld.onclick = setTimeout(function(){
    redVal = Math.floor(Math.random()*255) + 1;
    greenVal = Math.floor(Math.random()*255) + 1;
    blueVal = Math.floor(Math.random()*255) + 1;
    helloWorld.style.color = "rgb(" + redVal + ", " + greenVal + ", " + blueVal + ")";
  }, 3000);
};
delayColorChange();

/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM.
Use recursion.
On each node, call func(node).
*/







