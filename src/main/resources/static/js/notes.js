let logOutButton = document.getElementById('log-out-button');

logOutButton.addEventListener('click', event => {
    
    let request = new XMLHttpRequest();

    request.open('POST', 'logout', true);
    request.onload = function () {
        document.location.reload();
    }
    request.send();
});
