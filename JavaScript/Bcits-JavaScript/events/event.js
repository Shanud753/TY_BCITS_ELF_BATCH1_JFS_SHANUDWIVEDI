var pElement = document.createElement('h3');

function showAlert() {
    alert("Hi Welcome to Cinema Hall !!!")
}

function createEle() {

    pElement.textContent = 'welcome'
    document.body.appendChild(pElement)
}

function displayElement() {
    var dispElement = document.getElementById('disp')
    var myBtn = document.getElementById('myBtn');
    if (dispElement.style.display === '' || dispElement.style.display === 'none') {

        dispElement.style.display = 'block'
        myBtn.textContent = 'Click here to hide h1 Element'

    } else {
        dispElement.style.display = 'none'
        myBtn.textContent = 'Click here to show h1 Element'
    }
}

function changeBgcolorToBlue() {
    var color = document.getElementById('cgColor')
    color.style.backgroundColor = 'green'
    color.style.fontSize = '100px'
}

function changeBgcolorToWhite() {
    var color = document.getElementById('cgColor')
    color.style.backgroundColor = 'white'
    color.style.fontSize = '20px'
}

function showData() {
    console.log('working!!!');
}

function showDetail() {
    console.log('on key down executed');
}

function getInputValue() {
    var inpElement = document.getElementById('inp')
    console.log(inpElement.value);

    var showElement = document.getElementById('show')
    showElement.textContent = inpElement.value
}