# url-shortener-web3j

This is a adaptation of URL Shortener [URL Shortener](https://github.com/mohamedelshami/AKAP-url-shortener) to incorporate [web3j sdk](http://docs.web3j.io/quickstart/).

## Try

Start Ganache development network, and deploy AKAP.sol from AKAP [contracts](https://github.com/cfelde/AKAP/tree/master/contracts) directory:

    $ configure environment varaible in app.properties [development|demo] 

Make sure to update address as required within `src/main/web/contracts/AKAP.json`

Start webpack dev server with gradle run task:

    $ ./gradlew -t run

Start your browser at:

    $ http://localhost:8080/

