

(function () {
    var playlist = Array.from(document.querySelectorAll("ytd-playlist-video-renderer.style-scope.ytd-playlist-video-list-renderer"))

    //    console.log(playlist.length)

    var deleteItem = function () {
            var menuButtons = Array.from(document.querySelectorAll(".style-scope.ytd-menu-popup-renderer ytd-menu-service-item-renderer"))
        //var menuButtons = Array.from(document.querySelectorAll("paper-listbox.style-scope.ytd-menu-popup-renderer"))
        var deleteButton = menuButtons[2]
        console.log(menuButtons)
        deleteButton.click()

    }

    playlist.forEach(function (pItem) {
        var btn = pItem.querySelector("button");
        btn.click();
        deleteItem();

    })

})()
