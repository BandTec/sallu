FROM node:13-alpine as build-stage

WORKDIR /app

COPY package*.json yarn.lock /app/

RUN yarn install

COPY . /app/

COPY prod.env .env

RUN yarn build

FROM nginx:1.15

COPY --from=build-stage /app/build/ /usr/share/nginx/html

EXPOSE 80