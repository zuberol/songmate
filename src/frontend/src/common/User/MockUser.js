import User from "./User";
import mockTopArtistsList from './MockTopArtistsList';

const userMe = {
    "country": "PL",
    "display_name": "Jakub Żuber",
    "email": "kubazuber@wp.pl",
    "explicit_content": {
      "filter_enabled": false,
      "filter_locked": false
    },
    "external_urls": {
      "spotify": "https://open.spotify.com/user/11130189786"
    },
    "followers": {
      "href": null,
      "total": 20
    },
    "href": "https://api.spotify.com/v1/users/11130189786",
    "id": "11130189786",
    "images": [
      {
        "height": null,
        "url": "https://scontent-amt2-1.xx.fbcdn.net/v/t1.0-1/p320x320/116882112_3091784044223479_1806181044416887834_n.jpg?_nc_cat=105&ccb=2&_nc_sid=0c64ff&_nc_ohc=0OCNK8S27YYAX-vMN2K&_nc_ht=scontent-amt2-1.xx&tp=6&oh=48ceca67a02fef70d4e5d44a6aebccb0&oe=60417A0C",
        "width": null
      }
    ],
    "product": "open",
    "type": "user",
    "uri": "spotify:user:11130189786"
}

const mockAbout = "Vestibulum malesuada cursus nisl. Suspendisse et bibendum nibh. Duis id urna tincidunt, mattis nibh nec, aliquet orci. Nunc vel risus vitae dolor pellentesque ultrices. In porttitor velit orci, quis sagittis nisi auctor sed. Cras tristique dignissim purus vel pulvinar. Proin quis pharetra tellus, vitae posuere magna. Sed tincidunt ante et metus rhoncus aliquet. Sed non rhoncus mauris.";

const MockUser = new User(
    userMe.display_name,
    userMe.images[0].url,
    mockTopArtistsList,
    mockAbout
);

export default MockUser;