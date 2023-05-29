#!/bin/bash

set -e

# Descargar y extraer el archivo comprimido de ChromeDriver
wget https://chromedriver.storage.googleapis.com/94.0.4606.61/chromedriver_linux64.zip
unzip chromedriver_linux64.zip

# Dar permisos de ejecución a ChromeDriver
chmod +x chromedriver

# Mover ChromeDriver al directorio /usr/local/bin para que esté en el PATH del sistema
sudo mv chromedriver /usr/local/bin/

# Verificar la versión de ChromeDriver instalada
chromedriver --version
