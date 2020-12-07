yarn install

cp ./prod.env ./.env

yarn build

rm -rf /usr/share/nginx/html/*

cp ./build/* /usr/share/nginx/html
