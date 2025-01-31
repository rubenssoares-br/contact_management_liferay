# Contact_management_liferay

This project, built using the Liferay framework's Service Builder and REST Builder, creates a contact management system.  It offers several advantages, including efficient searching, organized contact storage, and data accuracy, among other features.

## Requirements
  - Blade
  - Docker
  - Gradle
  - Java11

## Build and Up project

### Download the bundle

Run the command to initialize and download the bundle:

  ```
  blade gw initBundle
  ```

### Deploy

Navigate to the modules folder and run the command:

  ```
  blade gw clean deploy
  ```

### Up the Services

Return to the root folder where the `docker-compose.yml` file is located and start the services:

  ```
  docker compose up
  ```

To view the logs for a specific service, use the following command:

  ```
  docker compose logs -f ${service name}
  ```

## Notes

This project primarily focuses on the back end. To test the remote services, navigate to http://localhost:8080/api/jsonws.  To test the headless layer built with REST Builder, navigate to http://localhost:8080/o/api.


