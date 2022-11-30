# Java Microservice Template -  deployable to Azure Web App

Includes code hints for the following components:
* mongodb template (dependencies only)
* rest controller using openapi swagger generated library

## How it works
The REST endpoint users/v1/user/{id} is implemented and returns an User randomly populated POJO.

## What it needs
The following CI variables must be set:
* CI_SUBSCRIPTION
* CI_APPNAME
* CI_RESOURCEGROUPNAME
