# crud Example

SWAGGER:
http://localhost:8084/swagger-ui.html

cURL:
curl --location --request GET 'http://localhost:8084/api/petz/retrieve/cliente' \
--header 'Content-Type: application/json'

curl --location --request GET 'http://localhost:8084/api/petz/retrieve/pet' \
--header 'Content-Type: application/json'

curl --location --request POST 'http://localhost:8084/api/petz/create/cliente' \
--header 'Content-Type: application/json' \
--data-raw ' {      
"nome": "Jeane",
"sexo": "Feminino",
"cpf": "02503199511",
"pet": "Gato"
}
'

curl --location --request POST 'http://localhost:8084/api/petz/create/pet' \
--header 'Content-Type: application/json' \
--data-raw '    {
"tipoPet": "cachorro TESTE",
"idade": "adulto",
"produto": "racao golden special",
"valor": 139.9
}'

curl --location --request PUT 'http://localhost:8084/api/petz/update/cliente/14' \
--header 'Content-Type: application/json' \
--data-raw '{
"nome": "Teste",
"sexo": "Feminino",
"cpf": "02503199500",
"pet": "Cachorroo"
}'

curl --location --request PUT 'http://localhost:8084/api/petz/update/pet/21' \
--header 'Content-Type: application/json' \
--data-raw '{
"tipoPet": "cachorro 21",
"idade": "adulto",
"produto": "racao golden special",
"valor": 139.9
}'

curl --location --request DELETE 'http://localhost:8084/api/petz/delete/cliente?id=11' \
--header 'Content-Type: application/json' \
--data-raw ''

curl --location --request DELETE 'http://localhost:8084/api/petz/delete/pet?id=11' \
--header 'Content-Type: application/json' \
--data-raw ''
