package com.luizconrado.weisshaus.solarisbankapi_v2.services;

public class Auth0Authentication {

    /*

    curl --request POST \
  --url 'https://YOUR_DOMAIN/oauth/token' \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=client_credentials \
  --data 'client_id=YOUR_CLIENT_ID' \
  --data client_secret=YOUR_CLIENT_SECRET \
  --data 'audience=https://YOUR_DOMAIN/api/v2/'


   Get Data:
   curl
   -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9CWnBWTFlxTTVINW9TbHpsbWZpayJ9.eyJpc3MiOiJodHRwczovL2RpZ2liYW5rLWV2LmV1LmF1dGgwLmNvbS8iLCJzdWIiOiJ3UEJYdzNEUlF6OEZaeGpkZGVJWE10YlgwOENmZlB2NUBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9kaWdpYmFuay1ldi5ldS5hdXRoMC5jb20vYXBpL3YyLyIsImlhdCI6MTYwNzMxMjM3OCwiZXhwIjoxNjA3Mzk4Nzc4LCJhenAiOiJ3UEJYdzNEUlF6OEZaeGpkZGVJWE10YlgwOENmZlB2NSIsInNjb3BlIjoicmVhZDpjbGllbnRfZ3JhbnRzIGNyZWF0ZTpjbGllbnRfZ3JhbnRzIGRlbGV0ZTpjbGllbnRfZ3JhbnRzIHVwZGF0ZTpjbGllbnRfZ3JhbnRzIHJlYWQ6dXNlcnMgdXBkYXRlOnVzZXJzIGRlbGV0ZTp1c2VycyBjcmVhdGU6dXNlcnMgcmVhZDp1c2Vyc19hcHBfbWV0YWRhdGEgdXBkYXRlOnVzZXJzX2FwcF9tZXRhZGF0YSBkZWxldGU6dXNlcnNfYXBwX21ldGFkYXRhIGNyZWF0ZTp1c2Vyc19hcHBfbWV0YWRhdGEgcmVhZDp1c2VyX2N1c3RvbV9ibG9ja3MgY3JlYXRlOnVzZXJfY3VzdG9tX2Jsb2NrcyBkZWxldGU6dXNlcl9jdXN0b21fYmxvY2tzIGNyZWF0ZTp1c2VyX3RpY2tldHMgcmVhZDpjbGllbnRzIHVwZGF0ZTpjbGllbnRzIGRlbGV0ZTpjbGllbnRzIGNyZWF0ZTpjbGllbnRzIHJlYWQ6Y2xpZW50X2tleXMgdXBkYXRlOmNsaWVudF9rZXlzIGRlbGV0ZTpjbGllbnRfa2V5cyBjcmVhdGU6Y2xpZW50X2tleXMgcmVhZDpjb25uZWN0aW9ucyB1cGRhdGU6Y29ubmVjdGlvbnMgZGVsZXRlOmNvbm5lY3Rpb25zIGNyZWF0ZTpjb25uZWN0aW9ucyByZWFkOnJlc291cmNlX3NlcnZlcnMgdXBkYXRlOnJlc291cmNlX3NlcnZlcnMgZGVsZXRlOnJlc291cmNlX3NlcnZlcnMgY3JlYXRlOnJlc291cmNlX3NlcnZlcnMgcmVhZDpkZXZpY2VfY3JlZGVudGlhbHMgdXBkYXRlOmRldmljZV9jcmVkZW50aWFscyBkZWxldGU6ZGV2aWNlX2NyZWRlbnRpYWxzIGNyZWF0ZTpkZXZpY2VfY3JlZGVudGlhbHMgcmVhZDpydWxlcyB1cGRhdGU6cnVsZXMgZGVsZXRlOnJ1bGVzIGNyZWF0ZTpydWxlcyByZWFkOnJ1bGVzX2NvbmZpZ3MgdXBkYXRlOnJ1bGVzX2NvbmZpZ3MgZGVsZXRlOnJ1bGVzX2NvbmZpZ3MgcmVhZDpob29rcyB1cGRhdGU6aG9va3MgZGVsZXRlOmhvb2tzIGNyZWF0ZTpob29rcyByZWFkOmFjdGlvbnMgdXBkYXRlOmFjdGlvbnMgZGVsZXRlOmFjdGlvbnMgY3JlYXRlOmFjdGlvbnMgcmVhZDplbWFpbF9wcm92aWRlciB1cGRhdGU6ZW1haWxfcHJvdmlkZXIgZGVsZXRlOmVtYWlsX3Byb3ZpZGVyIGNyZWF0ZTplbWFpbF9wcm92aWRlciBibGFja2xpc3Q6dG9rZW5zIHJlYWQ6c3RhdHMgcmVhZDp0ZW5hbnRfc2V0dGluZ3MgdXBkYXRlOnRlbmFudF9zZXR0aW5ncyByZWFkOmxvZ3MgcmVhZDpsb2dzX3VzZXJzIHJlYWQ6c2hpZWxkcyBjcmVhdGU6c2hpZWxkcyB1cGRhdGU6c2hpZWxkcyBkZWxldGU6c2hpZWxkcyByZWFkOmFub21hbHlfYmxvY2tzIGRlbGV0ZTphbm9tYWx5X2Jsb2NrcyB1cGRhdGU6dHJpZ2dlcnMgcmVhZDp0cmlnZ2VycyByZWFkOmdyYW50cyBkZWxldGU6Z3JhbnRzIHJlYWQ6Z3VhcmRpYW5fZmFjdG9ycyB1cGRhdGU6Z3VhcmRpYW5fZmFjdG9ycyByZWFkOmd1YXJkaWFuX2Vucm9sbG1lbnRzIGRlbGV0ZTpndWFyZGlhbl9lbnJvbGxtZW50cyBjcmVhdGU6Z3VhcmRpYW5fZW5yb2xsbWVudF90aWNrZXRzIHJlYWQ6dXNlcl9pZHBfdG9rZW5zIGNyZWF0ZTpwYXNzd29yZHNfY2hlY2tpbmdfam9iIGRlbGV0ZTpwYXNzd29yZHNfY2hlY2tpbmdfam9iIHJlYWQ6Y3VzdG9tX2RvbWFpbnMgZGVsZXRlOmN1c3RvbV9kb21haW5zIGNyZWF0ZTpjdXN0b21fZG9tYWlucyB1cGRhdGU6Y3VzdG9tX2RvbWFpbnMgcmVhZDplbWFpbF90ZW1wbGF0ZXMgY3JlYXRlOmVtYWlsX3RlbXBsYXRlcyB1cGRhdGU6ZW1haWxfdGVtcGxhdGVzIHJlYWQ6bWZhX3BvbGljaWVzIHVwZGF0ZTptZmFfcG9saWNpZXMgcmVhZDpyb2xlcyBjcmVhdGU6cm9sZXMgZGVsZXRlOnJvbGVzIHVwZGF0ZTpyb2xlcyByZWFkOnByb21wdHMgdXBkYXRlOnByb21wdHMgcmVhZDpicmFuZGluZyB1cGRhdGU6YnJhbmRpbmcgZGVsZXRlOmJyYW5kaW5nIHJlYWQ6bG9nX3N0cmVhbXMgY3JlYXRlOmxvZ19zdHJlYW1zIGRlbGV0ZTpsb2dfc3RyZWFtcyB1cGRhdGU6bG9nX3N0cmVhbXMgY3JlYXRlOnNpZ25pbmdfa2V5cyByZWFkOnNpZ25pbmdfa2V5cyB1cGRhdGU6c2lnbmluZ19rZXlzIHJlYWQ6bGltaXRzIHVwZGF0ZTpsaW1pdHMgY3JlYXRlOnJvbGVfbWVtYmVycyByZWFkOnJvbGVfbWVtYmVycyBkZWxldGU6cm9sZV9tZW1iZXJzIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.AeJ5JZrjAnJPBKrSPhiPe4A6J7F2aXVqxMDzOhmrrtm5Gdtq8nMV0fiRu4QkAGt14mXZ5Y81Fk07turtWCfw0N-Ki_0vM9q0NS3Bi6HdOCnSYy7XbaOX_3i10zVarLTo-cLDS9Mi-JnlbPxa3zjUNT8CiboTPgI_M8Jhqn5-cErimxwT6fxNXlTS4cdHdjU3Bhf_mcHRRll9Bqv_5HSg5iingSoTrPj-ouf8gD3ELjFi6AuX_TZznt7G9anF6UwHlarT9vmIDuGXSxAwsdVl4MCur0RW5VMlKZcEwkvCa1jh3iicemubTQ8BYaL5MlFIGTVR1Vj6UpDNpy9gLgKmww"
   https://digibank-ev.eu.auth0.com/api/v2/users?page=0&per_page=100&sort=created_at%3A-1


[
  {
    "created_at": "2020-12-04T15:06:50.754Z",
    "email": "sebastian.weikart+testreview@finleap.com",
    "email_verified": true,
    "family_name": "Weikart",
    "given_name": "Sebastian",
    "identities": [
      {
        "user_id": "68423a51-21f4-4dc3-97b4-6158db55d106",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "sebastian.weikart+testreview@finleap.com",
    "nickname": "sebastian.weikart+testreview",
    "picture": "https://s.gravatar.com/avatar/d077d29fd768b0005cfb8bf65086e00f?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fse.png",
    "updated_at": "2020-12-04T15:07:47.228Z",
    "user_id": "auth0|68423a51-21f4-4dc3-97b4-6158db55d106",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "+49015034342323"
    },
    "last_login": "2020-12-04T15:07:47.227Z",
    "last_ip": "95.88.153.15",
    "logins_count": 1
  },
  {
    "created_at": "2020-12-03T12:12:45.341Z",
    "email": "franziska.brendel+208@finleap.com",
    "email_verified": true,
    "family_name": "Brendel",
    "given_name": "Franziska Barbara",
    "identities": [
      {
        "user_id": "13128023-7890-4a55-a8e9-85017ca51284",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "franziska.brendel+208@finleap.com",
    "nickname": "franziska.brendel+208",
    "picture": "https://s.gravatar.com/avatar/8c08b71e58264fd1cdba0ba080f1b4c7?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-12-03T12:22:57.154Z",
    "user_id": "auth0|13128023-7890-4a55-a8e9-85017ca51284",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.86,es-UN;q=0.71,en-GB;q=0.57,pt-BR;q=0.43,ja-DE;q=0.29,zh-Hans-DE;q=0.14",
      "person_id": "326aeb7c627e59adacffdeb8bd3650e7cper"
    },
    "last_login": "2020-12-03T12:12:46.471Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-12-02T18:35:58.405Z",
    "email": "roman.smigiel+wealth011@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "599b9a73-7639-4032-9082-f23b54b61ead",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "R S",
    "nickname": "roman.smigiel+wealth011",
    "picture": "https://s.gravatar.com/avatar/ee30e548c1e3e8c28f2fba1254693439?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Frs.png",
    "updated_at": "2020-12-02T18:36:18.722Z",
    "user_id": "auth0|599b9a73-7639-4032-9082-f23b54b61ead",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-02T18:23:20.738Z",
    "email": "roman.smigiel+wealth010@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Blow",
    "given_name": "Joe",
    "identities": [
      {
        "user_id": "057cd051-834d-4d50-8bd6-312c26f7cfba",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Joe Blow",
    "nickname": "roman.smigiel+wealth010",
    "picture": "https://s.gravatar.com/avatar/6b049e7127bab8e8ec361d6d5150b8e1?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fjb.png",
    "updated_at": "2020-12-02T18:23:35.115Z",
    "user_id": "auth0|057cd051-834d-4d50-8bd6-312c26f7cfba",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-02T17:09:52.488Z",
    "email": "philippschemel@hotmail.com",
    "email_verified": true,
    "family_name": "Schemel",
    "given_name": "Philipp",
    "identities": [
      {
        "user_id": "c81f7e23-9828-46d5-bbeb-4d4a9ca35777",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "philippschemel@hotmail.com",
    "nickname": "philippschemel",
    "picture": "https://s.gravatar.com/avatar/f535d67002c555a8bf8eaeeabf213d50?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fph.png",
    "updated_at": "2020-12-02T17:10:48.217Z",
    "user_id": "auth0|c81f7e23-9828-46d5-bbeb-4d4a9ca35777",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE",
      "person_id": "8dc91b23c4f5f8ceefaa1925998b6a4acper"
    },
    "last_login": "2020-12-02T17:09:53.392Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-12-02T17:02:47.384Z",
    "email": "roman.smigiel+wealth009@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "f18829ca-587c-45cd-b40d-4e4830c3d813",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+wealth009@weisshausinvestment.com",
    "nickname": "roman.smigiel+wealth009",
    "picture": "https://s.gravatar.com/avatar/2ae7d12719854f88a0cf997ead307acf?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-12-02T17:04:03.754Z",
    "user_id": "auth0|f18829ca-587c-45cd-b40d-4e4830c3d813",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-12-02T17:04:03.754Z",
    "last_ip": "2a02:8109:8a00:6184:3534:26aa:21cc:6f60",
    "logins_count": 1
  },
  {
    "created_at": "2020-12-01T21:14:48.762Z",
    "email": "sebastian.weikart+test05@finleap.com",
    "email_verified": true,
    "family_name": "Weikart",
    "given_name": "Sebastian",
    "identities": [
      {
        "user_id": "fe855f4d-067a-4848-ba2e-d56dda64d05f",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "sebastian.weikart+test05@finleap.com",
    "nickname": "sebastian.weikart+test05",
    "picture": "https://s.gravatar.com/avatar/78e5896bbc2c9b0973b7e90742ec1c83?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fse.png",
    "updated_at": "2020-12-01T21:16:49.729Z",
    "user_id": "auth0|fe855f4d-067a-4848-ba2e-d56dda64d05f",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "+49015290068232"
    },
    "last_login": "2020-12-01T21:16:49.729Z",
    "last_ip": "95.88.153.15",
    "logins_count": 1
  },
  {
    "created_at": "2020-12-01T17:50:59.067Z",
    "email": "roman.smigiel+wealth008@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "1bbba55f-2c62-4d57-8e99-69cbfa077c61",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+wealth008@weisshausinvestment.com",
    "nickname": "roman.smigiel+wealth008",
    "picture": "https://s.gravatar.com/avatar/818346a1bae975176e9dac2d8ab6773d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-12-01T17:53:46.724Z",
    "user_id": "auth0|1bbba55f-2c62-4d57-8e99-69cbfa077c61",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-12-01T17:53:46.724Z",
    "last_ip": "2a02:8109:8a00:6184:dab:74b8:be15:1638",
    "logins_count": 2
  },
  {
    "created_at": "2020-12-01T16:58:47.709Z",
    "email": "ersin.isimtekin+test-1234565@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "50cf803f-409f-4e92-961c-a5904e02f607",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+test-1234565",
    "picture": "https://s.gravatar.com/avatar/2760a32d3f83fff105a49cee68416953?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-12-01T16:58:47.709Z",
    "user_id": "auth0|50cf803f-409f-4e92-961c-a5904e02f607",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T16:24:43.746Z",
    "email": "gareth.fox+21@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Fox",
    "given_name": "Gareth",
    "identities": [
      {
        "user_id": "189f2637-9e95-438f-a70d-c3aa4e218c0f",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gareth.fox+21@weisshausinvestment.com",
    "nickname": "gareth.fox+21",
    "picture": "https://s.gravatar.com/avatar/a3b49aa60a5973991a9f59157439e290?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fga.png",
    "updated_at": "2020-12-01T16:26:11.340Z",
    "user_id": "auth0|189f2637-9e95-438f-a70d-c3aa4e218c0f",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-GB,de-GB;q=0.5",
      "person_id": "9fc61200f9b3dfc58a167f0122408c80cper"
    },
    "last_login": "2020-12-01T16:24:44.674Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-12-01T15:44:45.867Z",
    "email": "roman.smigiel+wealth007@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "072afbae-d982-4a36-bd9b-200bd1b8c643",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "R S",
    "nickname": "roman.smigiel+wealth007",
    "picture": "https://s.gravatar.com/avatar/ffe09a3958494a92bd304cca33e981f0?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Frs.png",
    "updated_at": "2020-12-01T15:52:59.698Z",
    "user_id": "auth0|072afbae-d982-4a36-bd9b-200bd1b8c643",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T14:22:35.008Z",
    "email": "ersin.isimtekin+welcome-test8@finbyte.com",
    "email_verified": true,
    "family_name": "xx",
    "given_name": "xxx",
    "identities": [
      {
        "user_id": "b85fc6ec-632d-4513-b524-ee7da682f623",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "xxx xx",
    "nickname": "ersin.isimtekin+welcome-test8",
    "picture": "https://s.gravatar.com/avatar/7a19f7d9cb097d808df1c27d93797eae?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fxx.png",
    "updated_at": "2020-12-01T14:24:33.870Z",
    "user_id": "auth0|b85fc6ec-632d-4513-b524-ee7da682f623",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T14:20:11.807Z",
    "email": "ersin.isimtekin+welcome-test7@finbyte.com",
    "email_verified": true,
    "family_name": "xxx",
    "given_name": "xxx",
    "identities": [
      {
        "user_id": "2631e7b3-e0fa-40fb-a109-dd43c96bedd3",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "xxx xxx",
    "nickname": "ersin.isimtekin+welcome-test7",
    "picture": "https://s.gravatar.com/avatar/5702a63ef7d66592f54382fcb794884f?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fxx.png",
    "updated_at": "2020-12-01T14:21:00.907Z",
    "user_id": "auth0|2631e7b3-e0fa-40fb-a109-dd43c96bedd3",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T14:14:15.900Z",
    "email": "ersin.isimtekin+welcome-test6@finbyte.com",
    "email_verified": true,
    "family_name": "asd",
    "given_name": "asd",
    "identities": [
      {
        "user_id": "fda5633a-e461-4ed8-8ba9-e5c92ee05a8a",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "asd asd",
    "nickname": "ersin.isimtekin+welcome-test6",
    "picture": "https://s.gravatar.com/avatar/ca5ca544e2405afb0da3d989cb2b335d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Faa.png",
    "updated_at": "2020-12-01T14:15:46.141Z",
    "user_id": "auth0|fda5633a-e461-4ed8-8ba9-e5c92ee05a8a",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T14:01:36.625Z",
    "email": "ersin.isimtekin+welcome-test3@finbyte.com",
    "email_verified": true,
    "family_name": "asd",
    "given_name": "asd",
    "identities": [
      {
        "user_id": "87b7bd12-fc0d-47bb-86fd-502036db3b99",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "asd asd",
    "nickname": "ersin.isimtekin+welcome-test3",
    "picture": "https://s.gravatar.com/avatar/1650faba763a362340eb869474dc8917?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Faa.png",
    "updated_at": "2020-12-01T14:05:20.162Z",
    "user_id": "auth0|87b7bd12-fc0d-47bb-86fd-502036db3b99",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T13:51:37.161Z",
    "email": "ersin.isimtekin+welcome-test2@finbyte.com",
    "email_verified": true,
    "family_name": "Welcome",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "90aef29e-1c4b-4204-b8e8-1d2f306147e6",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Welcome",
    "nickname": "ersin.isimtekin+welcome-test2",
    "picture": "https://s.gravatar.com/avatar/e970f627d5455abb0a9a092df26713fc?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Few.png",
    "updated_at": "2020-12-01T13:51:51.532Z",
    "user_id": "auth0|90aef29e-1c4b-4204-b8e8-1d2f306147e6",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T13:42:43.341Z",
    "email": "ersin.isimtekin+welcome-test1@finbyte.com",
    "email_verified": true,
    "family_name": "welcome",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "287c0a6c-40e5-46f0-92d6-0eb1c2434f5c",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin welcome",
    "nickname": "ersin.isimtekin+welcome-test1",
    "picture": "https://s.gravatar.com/avatar/0dd9444b24d47573f645b44272820038?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Few.png",
    "updated_at": "2020-12-01T13:42:57.885Z",
    "user_id": "auth0|287c0a6c-40e5-46f0-92d6-0eb1c2434f5c",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T13:31:57.197Z",
    "email": "ersin.isimtekin+welcome-test@finbyte.com",
    "email_verified": true,
    "family_name": "isimtekin",
    "given_name": "ersin",
    "identities": [
      {
        "user_id": "f52d4763-9f9f-4e91-afb3-c5fc795a052f",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "ersin isimtekin",
    "nickname": "ersin.isimtekin+welcome-test",
    "picture": "https://s.gravatar.com/avatar/7118c9a95908cb2e667c05d7450a6d9b?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-12-01T13:36:13.731Z",
    "user_id": "auth0|f52d4763-9f9f-4e91-afb3-c5fc795a052f",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-12-01T13:10:22.285Z",
    "email": "joe.latt+005@engelvoelkers.com",
    "email_verified": true,
    "family_name": "Latt",
    "given_name": "Joe",
    "identities": [
      {
        "user_id": "52c48a04-dd70-4af2-a2e5-d2d2302539c7",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "joe.latt+005@engelvoelkers.com",
    "nickname": "joe.latt+005",
    "picture": "https://s.gravatar.com/avatar/acf9548a0820e4321112e757989f6aa1?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fjo.png",
    "updated_at": "2020-12-01T13:10:58.127Z",
    "user_id": "auth0|52c48a04-dd70-4af2-a2e5-d2d2302539c7",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-GB;q=0.5"
    },
    "last_login": "2020-12-01T13:10:27.682Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-30T13:36:22.403Z",
    "email": "janakatharina.meyer+007@engelvoelkers.com",
    "email_verified": true,
    "family_name": "Meyer",
    "given_name": "Jana",
    "identities": [
      {
        "user_id": "abf2caa4-e8d5-4179-af92-2ed43bcfa6eb",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "janakatharina.meyer+007@engelvoelkers.com",
    "nickname": "janakatharina.meyer+007",
    "picture": "https://s.gravatar.com/avatar/6bff3952811f443fe624014321f477f5?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fja.png",
    "updated_at": "2020-12-04T08:44:05.612Z",
    "user_id": "auth0|abf2caa4-e8d5-4179-af92-2ed43bcfa6eb",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.5",
      "person_id": "0441eef0f178e5fe7f412f4d2d215694cper"
    },
    "last_login": "2020-11-30T13:36:23.270Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-30T13:35:13.629Z",
    "email": "janakatharina+006@engelvoelkers.com",
    "email_verified": false,
    "family_name": "Meyer",
    "given_name": "Jana",
    "identities": [
      {
        "user_id": "ce6b64df-e6ff-4db4-8ccf-551a9f10422c",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "janakatharina+006@engelvoelkers.com",
    "nickname": "janakatharina+006",
    "picture": "https://s.gravatar.com/avatar/4d309c798bcfdce2379ae757cbf1abf4?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fja.png",
    "updated_at": "2020-11-30T13:35:14.809Z",
    "user_id": "auth0|ce6b64df-e6ff-4db4-8ccf-551a9f10422c",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.5"
    },
    "last_login": "2020-11-30T13:35:14.802Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-30T13:33:35.178Z",
    "email": "janakatharina.meyer006@engelvoelkers.com",
    "email_verified": false,
    "family_name": "Meyer",
    "given_name": "Jana",
    "identities": [
      {
        "user_id": "09ff3598-b5f0-4eaa-ad90-05a8c9fb18a4",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "janakatharina.meyer006@engelvoelkers.com",
    "nickname": "janakatharina.meyer006",
    "picture": "https://s.gravatar.com/avatar/45ce9b80d39209bae22df0f361344632?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fja.png",
    "updated_at": "2020-11-30T13:33:35.910Z",
    "user_id": "auth0|09ff3598-b5f0-4eaa-ad90-05a8c9fb18a4",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.5"
    },
    "last_login": "2020-11-30T13:33:35.910Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-30T11:15:24.657Z",
    "email": "roman.smigiel+wealth006@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "67f28aa0-9d24-4de3-b6a2-116f24e298c1",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+wealth006@weisshausinvestment.com",
    "nickname": "roman.smigiel+wealth006",
    "picture": "https://s.gravatar.com/avatar/a3ef6614c11be844fe3218782f359d40?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-12-01T13:34:13.199Z",
    "user_id": "auth0|67f28aa0-9d24-4de3-b6a2-116f24e298c1",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-12-01T13:34:13.199Z",
    "last_ip": "2a02:8109:8a00:6184:1418:853:452c:179a",
    "logins_count": 10
  },
  {
    "created_at": "2020-11-30T10:55:00.904Z",
    "email": "ersin.isimtekin+login1221@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "14f93441-bbb5-4b8b-8c48-2d82fb57746b",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+login1221",
    "picture": "https://s.gravatar.com/avatar/ca40de7f635b3895c62bacc53f6da6c4?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-12-01T13:34:57.693Z",
    "user_id": "auth0|14f93441-bbb5-4b8b-8c48-2d82fb57746b",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-29T16:07:59.626Z",
    "email": "gemma.pinyol+99ev@finleap.com",
    "email_verified": true,
    "family_name": "Charlton",
    "given_name": "Ferhaan",
    "identities": [
      {
        "user_id": "d51be029-5f84-4ea1-82d5-75f89e145a8a",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+99ev@finleap.com",
    "nickname": "gemma.pinyol+99ev",
    "picture": "https://s.gravatar.com/avatar/18fff42fd4595b78eb6a9a825fb21c07?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-30T11:34:00.379Z",
    "user_id": "auth0|d51be029-5f84-4ea1-82d5-75f89e145a8a",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-AQ,en-AQ;q=0.75,es-AQ;q=0.5,fr-AQ;q=0.25",
      "person_id": "88941095d3077f0dd43d56f665956405cper"
    },
    "last_login": "2020-11-30T11:33:29.701Z",
    "last_ip": "52.29.11.71",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-29T15:52:30.043Z",
    "email": "gemma.pinyol+97ev@finleap.com",
    "email_verified": true,
    "family_name": "Crowther",
    "given_name": "Lula",
    "identities": [
      {
        "user_id": "3f1cf353-020c-4aab-bc9f-6910ff2aff0c",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+97ev@finleap.com",
    "nickname": "gemma.pinyol+97ev",
    "picture": "https://s.gravatar.com/avatar/1c255cd092f7124e5a97028d1678ce52?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-29T16:27:50.749Z",
    "user_id": "auth0|3f1cf353-020c-4aab-bc9f-6910ff2aff0c",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-ES;q=0.75,en-GB;q=0.5,ca-ES;q=0.25",
      "person_id": "cc7840eb43f24c00112252d25f8e540dcper"
    },
    "last_login": "2020-11-29T16:27:50.749Z",
    "last_ip": "52.29.11.71",
    "logins_count": 6
  },
  {
    "created_at": "2020-11-29T15:44:23.216Z",
    "email": "gemma.pinyol+96ev@finleap.com",
    "email_verified": true,
    "family_name": "Bannister",
    "given_name": "Tahmid",
    "identities": [
      {
        "user_id": "9ef2d437-8b2a-4a68-b502-f7a928c07fe8",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+96ev@finleap.com",
    "nickname": "gemma.pinyol+96ev",
    "picture": "https://s.gravatar.com/avatar/614af869596ad55e21d03d4dff27e3dc?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-12-02T11:23:55.362Z",
    "user_id": "auth0|9ef2d437-8b2a-4a68-b502-f7a928c07fe8",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.5",
      "person_id": "77e6a0ce8eb1a23d428b62c012893c95cper"
    },
    "last_login": "2020-12-02T11:23:55.361Z",
    "last_ip": "52.29.11.71",
    "logins_count": 6
  },
  {
    "created_at": "2020-11-29T15:32:27.468Z",
    "email": "gemma.pinyol+94ev@finleap.com",
    "email_verified": true,
    "family_name": "Mac",
    "given_name": "Javier",
    "identities": [
      {
        "user_id": "f5f119fb-0675-4bff-b1cb-b98cbac5266c",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+94ev@finleap.com",
    "nickname": "gemma.pinyol+94ev",
    "picture": "https://s.gravatar.com/avatar/7d3b83f39666aba198fd4e65957209c8?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-12-02T15:45:48.618Z",
    "user_id": "auth0|f5f119fb-0675-4bff-b1cb-b98cbac5266c",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-AQ,en-AQ;q=0.75,es-AQ;q=0.5,fr-AQ;q=0.25",
      "person_id": "41e0c01f8083261e11eb628a1867f48ecper"
    },
    "last_login": "2020-12-02T15:45:48.618Z",
    "last_ip": "52.29.11.71",
    "logins_count": 5
  },
  {
    "created_at": "2020-11-29T15:22:00.758Z",
    "email": "gemma.pinyol+93ev@finleap.com",
    "email_verified": true,
    "family_name": "Mcleaod",
    "given_name": "Korban",
    "identities": [
      {
        "user_id": "27067e2b-16d4-4926-8dd0-12431eaae83a",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+93ev@finleap.com",
    "nickname": "gemma.pinyol+93ev",
    "picture": "https://s.gravatar.com/avatar/7c196c67eaae03abe79c973a3bfb2a89?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-29T15:28:03.634Z",
    "user_id": "auth0|27067e2b-16d4-4926-8dd0-12431eaae83a",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-AQ,en-AQ;q=0.75,es-AQ;q=0.5,fr-AQ;q=0.25",
      "person_id": "8ab854d57f40f17dc6d913a00c4852b2cper"
    },
    "last_login": "2020-11-29T15:22:01.916Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-29T15:14:06.380Z",
    "email": "gemma.pinyol+92ev@finleap.com",
    "email_verified": true,
    "family_name": "Cantrell",
    "given_name": "Tanya",
    "identities": [
      {
        "user_id": "4ce90d01-648a-402e-a6e1-b865c59142fb",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+92ev@finleap.com",
    "nickname": "gemma.pinyol+92ev",
    "picture": "https://s.gravatar.com/avatar/b1dd3ad757fc9fd8f88d69f8d7a30b38?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-29T15:17:29.669Z",
    "user_id": "auth0|4ce90d01-648a-402e-a6e1-b865c59142fb",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-ES;q=0.75,en-GB;q=0.5,ca-ES;q=0.25",
      "person_id": "cb04146e7a201205fe11b2e0fe059158cper"
    },
    "last_login": "2020-11-29T15:16:31.907Z",
    "last_ip": "52.29.11.71",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-29T13:33:03.368Z",
    "email": "heinrich_nemeczek@gmx.net",
    "email_verified": true,
    "family_name": "Nemeczek",
    "given_name": "Heinrich",
    "identities": [
      {
        "user_id": "c012bddd-914b-4f17-bd45-1c3b3c6833bd",
        "provider": "auth0",
        "connection": "ev-prod-identity-store",
        "isSocial": false
      }
    ],
    "name": "heinrich_nemeczek@gmx.net",
    "nickname": "heinrich_nemeczek",
    "picture": "https://s.gravatar.com/avatar/3b0fbdba5648a99499e7ac8868eefda3?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fhe.png",
    "updated_at": "2020-11-29T14:20:16.892Z",
    "user_id": "auth0|c012bddd-914b-4f17-bd45-1c3b3c6833bd",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-US;q=0.5",
      "person_id": "fda89ddcd4845c18ef3758af631926b2cper"
    },
    "last_login": "2020-11-29T13:33:06.162Z",
    "last_ip": "18.157.89.67",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-27T15:46:31.302Z",
    "email": "gareth.fox+22@weissinvestment.com",
    "email_verified": false,
    "family_name": "OFx",
    "given_name": "Garewth ",
    "identities": [
      {
        "user_id": "61df3b9f-5632-4c51-8c10-c0019f4016ba",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Garewth  OFx",
    "nickname": "gareth.fox+22",
    "picture": "https://s.gravatar.com/avatar/892c0e914912e0761e479ff0a6821314?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fgo.png",
    "updated_at": "2020-11-27T15:46:31.302Z",
    "user_id": "auth0|61df3b9f-5632-4c51-8c10-c0019f4016ba",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-27T15:40:29.779Z",
    "email": "gareth.fox+22@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Fox",
    "given_name": "Gareth ",
    "identities": [
      {
        "user_id": "cab26078-f028-4e3c-b6e5-d9a52f84a894",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Gareth  Fox",
    "nickname": "gareth.fox+22",
    "picture": "https://s.gravatar.com/avatar/378b75987416d695b107c67178a4f0d0?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fgf.png",
    "updated_at": "2020-11-27T15:48:12.358Z",
    "user_id": "auth0|cab26078-f028-4e3c-b6e5-d9a52f84a894",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-27T09:31:53.619Z",
    "email": "roman.smigiel+wealth005@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "500699e8-024f-4ee4-92f2-e8a17217998d",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+wealth005@weisshausinvestment.com",
    "nickname": "roman.smigiel+wealth005",
    "picture": "https://s.gravatar.com/avatar/25a5d6544c1c6c30ae4dec5aef73657a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-11-30T10:50:00.837Z",
    "user_id": "auth0|500699e8-024f-4ee4-92f2-e8a17217998d",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-11-30T10:50:00.837Z",
    "last_ip": "2a02:8109:8a00:6184:d921:628a:9426:2eec",
    "logins_count": 11
  },
  {
    "created_at": "2020-11-26T16:05:11.159Z",
    "email": "gareth.fox+20@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Fox",
    "given_name": "Gareth",
    "identities": [
      {
        "user_id": "f63f8584-c335-4c0e-b3c1-8949f576f352",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gareth.fox+20@weisshausinvestment.com",
    "nickname": "gareth.fox+20",
    "picture": "https://s.gravatar.com/avatar/91ce26b23fae5b32d6bbe3f84df17c2a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fga.png",
    "updated_at": "2020-12-01T14:55:18.673Z",
    "user_id": "auth0|f63f8584-c335-4c0e-b3c1-8949f576f352",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-GB,en-GB;q=0.5",
      "person_id": "2b5568c3f1141d176fadebea474d83e7cper"
    },
    "last_login": "2020-12-01T14:55:18.673Z",
    "last_ip": "89.14.46.197",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-26T16:02:13.025Z",
    "email": "gareth.fox+020@weisshausinvestment.con",
    "email_verified": false,
    "family_name": "Fox",
    "given_name": "Gareth",
    "identities": [
      {
        "user_id": "b823b845-3896-475e-bf77-9f3e7dd3ed2f",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gareth.fox+020@weisshausinvestment.con",
    "nickname": "gareth.fox+020",
    "picture": "https://s.gravatar.com/avatar/2f809144302957fec03fadf1193257f0?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fga.png",
    "updated_at": "2020-11-26T16:02:18.222Z",
    "user_id": "auth0|b823b845-3896-475e-bf77-9f3e7dd3ed2f",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-GB,en-GB;q=0.5"
    },
    "last_login": "2020-11-26T16:02:18.222Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-26T14:55:22.416Z",
    "email": "sebastian.weikart+test04@finleap.com",
    "email_verified": false,
    "family_name": "Weikart",
    "given_name": "Sebastian",
    "identities": [
      {
        "user_id": "de73f21e-b48a-4d9d-ac5f-358235254f34",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Sebastian Weikart",
    "nickname": "sebastian.weikart+test04",
    "picture": "https://s.gravatar.com/avatar/3b746dcd3993a1205b4088037202f9b7?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fsw.png",
    "updated_at": "2020-11-26T14:55:22.416Z",
    "user_id": "auth0|de73f21e-b48a-4d9d-ac5f-358235254f34",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "+49015290068232"
    }
  },
  {
    "created_at": "2020-11-26T10:39:05.262Z",
    "email": "erik.krahl@gmail.com",
    "email_verified": true,
    "family_name": "Krahl",
    "given_name": "Erik",
    "identities": [
      {
        "user_id": "366131d0-4537-40d9-833c-f1a96a673f79",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "erik.krahl@gmail.com",
    "nickname": "erik.krahl",
    "picture": "https://s.gravatar.com/avatar/b91fb7ca51198c2389e1c102778be895?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fer.png",
    "updated_at": "2020-11-26T10:54:54.282Z",
    "user_id": "auth0|366131d0-4537-40d9-833c-f1a96a673f79",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE",
      "person_id": "436fc9650674c3b325578acc844d6b8fcper"
    },
    "last_login": "2020-11-26T10:39:05.997Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-26T10:27:42.450Z",
    "email": "sebastian.weikart+test03@finleap.com",
    "email_verified": true,
    "family_name": "weikart",
    "given_name": "sebastian",
    "identities": [
      {
        "user_id": "c0ad4f6f-5019-478d-968d-c15158a9b4c8",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "sebastian.weikart+test03@finleap.com",
    "nickname": "sebastian.weikart+test03",
    "picture": "https://s.gravatar.com/avatar/9addd27274e411afc551722dd9b187af?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fse.png",
    "updated_at": "2020-12-02T11:20:56.870Z",
    "user_id": "auth0|c0ad4f6f-5019-478d-968d-c15158a9b4c8",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "49015290068232",
      "language": "en-DE,de-DE;q=0.67,bg-DE;q=0.33",
      "person_id": "8b4b0946aa99cf182e3b2625916103f2cper"
    },
    "last_login": "2020-11-26T10:53:51.133Z",
    "last_ip": "52.29.11.71",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-26T10:19:30.032Z",
    "email": "sebastian.weikart+test3@finleaq.com",
    "email_verified": false,
    "family_name": "Weikart",
    "given_name": "Sebastian",
    "identities": [
      {
        "user_id": "7c6f21e8-d634-40a5-ab39-a49e3ba4007f",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Sebastian Weikart",
    "nickname": "sebastian.weikart+test3",
    "picture": "https://s.gravatar.com/avatar/8e7ee87f5f699bbcd1def3a89768ffcd?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fsw.png",
    "updated_at": "2020-11-26T10:19:30.032Z",
    "user_id": "auth0|7c6f21e8-d634-40a5-ab39-a49e3ba4007f",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "49232323232223"
    }
  },
  {
    "created_at": "2020-11-26T07:34:28.581Z",
    "email": "sebastian.weikart+test2@finleap.com",
    "email_verified": true,
    "family_name": "Weikart",
    "given_name": "Sebastian",
    "identities": [
      {
        "user_id": "18f3afd5-5968-417d-9d85-36b37f3bf256",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Sebastian Weikart",
    "nickname": "sebastian.weikart+test2",
    "picture": "https://s.gravatar.com/avatar/b31f5faf38b23e63baa3e27a9b5569f8?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fsw.png",
    "updated_at": "2020-11-26T07:35:19.242Z",
    "user_id": "auth0|18f3afd5-5968-417d-9d85-36b37f3bf256",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "49015290068232"
    }
  },
  {
    "created_at": "2020-11-25T18:47:55.293Z",
    "email": "mdanjfpkfa@fsfsf.de",
    "email_verified": false,
    "family_name": "Danzmann",
    "given_name": "Max",
    "identities": [
      {
        "user_id": "d6875f08-1c8b-4a87-a7f8-5dcc5434dcda",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Max Danzmann",
    "nickname": "mdanjfpkfa",
    "picture": "https://s.gravatar.com/avatar/eb220459e35fadd9d9754cab2a8e8683?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fmd.png",
    "updated_at": "2020-11-25T18:47:55.293Z",
    "user_id": "auth0|d6875f08-1c8b-4a87-a7f8-5dcc5434dcda",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "492354362642362"
    }
  },
  {
    "created_at": "2020-11-25T18:06:43.222Z",
    "email": "gareth.fox@g.com",
    "email_verified": false,
    "family_name": "Fox",
    "given_name": "Gareth",
    "identities": [
      {
        "user_id": "de979d58-e3a0-43d7-83cb-d0a337ee5c7e",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gareth.fox@g.com",
    "nickname": "gareth.fox",
    "picture": "https://s.gravatar.com/avatar/cb01f65872e2c4d20cfc802507533254?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fga.png",
    "updated_at": "2020-11-25T18:06:44.152Z",
    "user_id": "auth0|de979d58-e3a0-43d7-83cb-d0a337ee5c7e",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-GB,en-GB;q=0.5"
    },
    "last_login": "2020-11-25T18:06:44.152Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-25T14:17:45.579Z",
    "email": "ersin.isimtekin+mobile@finbyte.com",
    "email_verified": false,
    "family_name": "mobile test",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "f2e5464b-6bc0-4705-96fb-0521a3b620b8",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin mobile test",
    "nickname": "ersin.isimtekin+mobile",
    "picture": "https://s.gravatar.com/avatar/633315006ec07db644f67d0b43ea389d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fem.png",
    "updated_at": "2020-11-25T14:17:45.579Z",
    "user_id": "auth0|f2e5464b-6bc0-4705-96fb-0521a3b620b8",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "905362787615"
    }
  },
  {
    "created_at": "2020-11-25T12:46:48.280Z",
    "email": "nynny@fjkf.cind",
    "email_verified": false,
    "family_name": "Nfnnff",
    "given_name": "Bdd",
    "identities": [
      {
        "user_id": "b8aa439b-476a-4b18-bcf9-377d1285384e",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "nynny@fjkf.cind",
    "nickname": "nynny",
    "picture": "https://s.gravatar.com/avatar/0b4bfd8a828f04b69bd51166d235417e?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fny.png",
    "updated_at": "2020-11-25T12:46:49.278Z",
    "user_id": "auth0|b8aa439b-476a-4b18-bcf9-377d1285384e",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.75,en-GB;q=0.5,ru-RU;q=0.25"
    },
    "last_login": "2020-11-25T12:46:49.278Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-23T12:25:31.092Z",
    "email": "gareth.fox+016@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Fox",
    "given_name": "Gareth",
    "identities": [
      {
        "user_id": "b52f11ff-dac9-4057-9f04-3a9e7cb5ad98",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gareth.fox+016@weisshausinvestment.com",
    "nickname": "gareth.fox+016",
    "picture": "https://s.gravatar.com/avatar/3771a4c9a4b6e2929b4e81db4e5b7b7b?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fga.png",
    "updated_at": "2020-11-25T12:15:59.749Z",
    "user_id": "auth0|b52f11ff-dac9-4057-9f04-3a9e7cb5ad98",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-GB,en-GB;q=0.5",
      "person_id": "8ebf396c68524d95cf599beacc29d3a9cper"
    },
    "last_login": "2020-11-25T12:15:59.749Z",
    "last_ip": "3.121.63.70",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-23T11:55:47.366Z",
    "email": "lfconrado.spam@gmail.com",
    "email_verified": true,
    "family_name": "Conrado",
    "given_name": "Luiz Felipe",
    "identities": [
      {
        "user_id": "a0ea6fe6-a96e-4e7e-a223-3fa26e043541",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "lfconrado.spam@gmail.com",
    "nickname": "lfconrado.spam",
    "picture": "https://s.gravatar.com/avatar/c99e323cd23eebe67f8e8dcdaa38f4fe?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Flf.png",
    "updated_at": "2020-11-23T11:58:09.556Z",
    "user_id": "auth0|a0ea6fe6-a96e-4e7e-a223-3fa26e043541",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-GB",
      "person_id": "179b3760a230e9c3a1046102ac839f07cper"
    },
    "last_login": "2020-11-23T11:55:48.371Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-20T10:14:54.890Z",
    "email": "gemma.pinyol+91ev@finleap.com",
    "email_verified": true,
    "family_name": "Woodard",
    "given_name": "Briana",
    "identities": [
      {
        "user_id": "27bb75a3-b8b2-4a73-84d5-6c55497d57c5",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+91ev@finleap.com",
    "nickname": "gemma.pinyol+91ev",
    "picture": "https://s.gravatar.com/avatar/55fdbaa4ea5c0efcd06b62a729d8e376?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-25T16:47:15.264Z",
    "user_id": "auth0|27bb75a3-b8b2-4a73-84d5-6c55497d57c5",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-AQ,de-AQ;q=0.75,es-AQ;q=0.5,fr-AQ;q=0.25",
      "person_id": "be1b28e87fd79517e3673f971f78b73acper"
    },
    "last_login": "2020-11-25T16:47:15.264Z",
    "last_ip": "52.29.11.71",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-17T22:53:56.331Z",
    "email": "maristany.klose@googlemail.com",
    "email_verified": true,
    "family_name": "Maristany Klose",
    "given_name": "Tim",
    "identities": [
      {
        "user_id": "1dcc6a26-fe9c-4086-a4e2-6cec393da573",
        "provider": "auth0",
        "connection": "ev-prod-identity-store",
        "isSocial": false
      }
    ],
    "name": "maristany.klose@googlemail.com",
    "nickname": "maristany.klose",
    "picture": "https://s.gravatar.com/avatar/d10f41afe7ed6f6b8ec849168c9c760a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fma.png",
    "updated_at": "2020-11-17T22:57:53.962Z",
    "user_id": "auth0|1dcc6a26-fe9c-4086-a4e2-6cec393da573",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,ru-DE;q=0.5",
      "person_id": "ccee5fed515ae72271de2a2b27f78458cper"
    },
    "last_login": "2020-11-17T22:53:57.651Z",
    "last_ip": "18.157.89.67",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-16T11:13:03.535Z",
    "email": "gemma.pinyol+90ev@finleap.com",
    "email_verified": true,
    "family_name": "Freeman",
    "given_name": "Gracie-Mai",
    "identities": [
      {
        "user_id": "0700ea23-1cca-4235-b95a-f75456606e2d",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+90ev@finleap.com",
    "nickname": "gemma.pinyol+90ev",
    "picture": "https://s.gravatar.com/avatar/2d13edf108ea7826f8d279022df1b4bd?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-19T11:01:39.231Z",
    "user_id": "auth0|0700ea23-1cca-4235-b95a-f75456606e2d",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-US,de-US;q=0.5",
      "person_id": "a2b58b7beb60b3ec035613da4fb4f40bcper"
    },
    "last_login": "2020-11-19T11:01:39.230Z",
    "last_ip": "52.29.11.71",
    "logins_count": 8
  },
  {
    "created_at": "2020-11-16T11:02:07.296Z",
    "email": "gemma.pinyol+89ev@finleap.com",
    "email_verified": true,
    "family_name": "Browne",
    "given_name": "Carwyn",
    "identities": [
      {
        "user_id": "b3244807-3d24-48a6-9bd4-7e8df24b9ae3",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+89ev@finleap.com",
    "nickname": "gemma.pinyol+89ev",
    "picture": "https://s.gravatar.com/avatar/34f2adb026476b0a9f4c0c783d0a2607?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-23T09:12:56.319Z",
    "user_id": "auth0|b3244807-3d24-48a6-9bd4-7e8df24b9ae3",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.75,fr-DE;q=0.5,es-DE;q=0.25",
      "person_id": "8e92c3ca20af7ef544e7b10226eb3a83cper"
    },
    "last_login": "2020-11-23T09:12:56.319Z",
    "last_ip": "52.29.11.71",
    "logins_count": 9
  },
  {
    "created_at": "2020-11-16T10:49:38.321Z",
    "email": "gemma.pinyol+88ev@finleap.com",
    "email_verified": true,
    "family_name": "Horner",
    "given_name": "Ashlee",
    "identities": [
      {
        "user_id": "9e8367bd-f242-4d8d-b985-f77377932e47",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+88ev@finleap.com",
    "nickname": "gemma.pinyol+88ev",
    "picture": "https://s.gravatar.com/avatar/43aa9077d25b4a5cb7c2dc6a961210a8?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-16T10:53:51.795Z",
    "user_id": "auth0|9e8367bd-f242-4d8d-b985-f77377932e47",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-ES;q=0.75,en-GB;q=0.5,ca-ES;q=0.25",
      "person_id": "beeeacad3140c98b317fdf3e56302bddcper"
    },
    "last_login": "2020-11-16T10:49:41.368Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-16T10:28:15.863Z",
    "email": "mail@thomas-wischniewski.de",
    "email_verified": true,
    "family_name": "Wischniewski",
    "given_name": "Thomas",
    "identities": [
      {
        "user_id": "e8c1427b-5c86-4794-bc09-651f4ada62df",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "mail@thomas-wischniewski.de",
    "nickname": "mail",
    "picture": "https://s.gravatar.com/avatar/15b08da4207d0c57afb8dd06ca32a474?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fma.png",
    "updated_at": "2020-11-16T10:44:58.950Z",
    "user_id": "auth0|e8c1427b-5c86-4794-bc09-651f4ada62df",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE",
      "person_id": "1b5bc7ad71fff2c69ec8afe859d28c4acper"
    },
    "last_login": "2020-11-16T10:28:16.608Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-16T10:27:58.991Z",
    "email": "gemma.pinyol+87ev@finleap.com",
    "email_verified": true,
    "family_name": "Ellis",
    "given_name": "Priya",
    "identities": [
      {
        "user_id": "324bbde1-bd0c-467a-bcef-8327b370e0f4",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+87ev@finleap.com",
    "nickname": "gemma.pinyol+87ev",
    "picture": "https://s.gravatar.com/avatar/d53757c108a24ded88f28215efbba8c2?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-12-01T12:03:12.490Z",
    "user_id": "auth0|324bbde1-bd0c-467a-bcef-8327b370e0f4",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.5",
      "person_id": "d86b26c32fc87b09287926ddcf4106e7cper"
    },
    "last_login": "2020-12-01T12:03:12.490Z",
    "last_ip": "3.121.63.70",
    "logins_count": 12
  },
  {
    "created_at": "2020-11-13T15:05:52.390Z",
    "email": "apiaibot2.germany@gmail.com",
    "email_verified": true,
    "family_name": "Furqan",
    "given_name": "Syed",
    "identities": [
      {
        "user_id": "fc587ce6-3c8a-45c8-8309-7def57365f9f",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "apiaibot2.germany@gmail.com",
    "nickname": "apiaibot2.germany",
    "picture": "https://s.gravatar.com/avatar/d4d89e1413c330de9619c0606dfd7b84?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fap.png",
    "updated_at": "2020-11-13T15:08:46.432Z",
    "user_id": "auth0|fc587ce6-3c8a-45c8-8309-7def57365f9f",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-US,en-IN;q=0.5",
      "person_id": "39525c309b2a66cc2ae94b69f475a617cper"
    },
    "last_login": "2020-11-13T15:05:53.300Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-13T08:52:58.359Z",
    "email": "gemma.pinyol+86ev@finleap.com",
    "email_verified": true,
    "family_name": "Everett",
    "given_name": "Aaliya",
    "identities": [
      {
        "user_id": "9ddfcde5-e8df-4c38-b9f8-a187871c476d",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+86ev@finleap.com",
    "nickname": "gemma.pinyol+86ev",
    "picture": "https://s.gravatar.com/avatar/ce20c508ec52c2be984b0a1f3505210d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-30T15:30:45.889Z",
    "user_id": "auth0|9ddfcde5-e8df-4c38-b9f8-a187871c476d",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-ES;q=0.75,en-GB;q=0.5,ca-ES;q=0.25"
    },
    "last_login": "2020-11-26T14:59:48.130Z",
    "last_ip": "52.29.11.71",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-13T07:55:05.733Z",
    "email": "me@sebweik.art",
    "email_verified": false,
    "family_name": "weikart",
    "given_name": "sebastian",
    "identities": [
      {
        "user_id": "1a2d8ed3-bc68-445c-bdca-987df77cf1f9",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "me@sebweik.art",
    "nickname": "me",
    "picture": "https://s.gravatar.com/avatar/80c8e2297411cd41d55c2b5f0bcb1d44?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fme.png",
    "updated_at": "2020-11-13T08:36:44.118Z",
    "user_id": "auth0|1a2d8ed3-bc68-445c-bdca-987df77cf1f9",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-11-13T08:36:44.117Z",
    "last_ip": "91.66.93.33",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-12T17:13:11.504Z",
    "email": "oleksiy.khoroshko@whu.edu",
    "email_verified": true,
    "family_name": "Khoroshko",
    "given_name": "Oleksiy",
    "identities": [
      {
        "user_id": "cabaaae4-6a10-444f-9f3a-9a4ec7e70fd4",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "oleksiy.khoroshko@whu.edu",
    "nickname": "oleksiy.khoroshko",
    "picture": "https://s.gravatar.com/avatar/74593ad714a054ab915c576c5bbd6e27?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fol.png",
    "updated_at": "2020-11-17T14:26:10.410Z",
    "user_id": "auth0|cabaaae4-6a10-444f-9f3a-9a4ec7e70fd4",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-DE;q=0.8,ru-DE;q=0.6,en-US;q=0.4,uk-UA;q=0.2",
      "person_id": "7a59df55161a56f31f249291b746f235cper"
    },
    "last_login": "2020-11-12T17:13:12.286Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-12T17:07:03.007Z",
    "email": "alexkhoroshko20@gmail.com",
    "email_verified": true,
    "family_name": "Khoroshko",
    "given_name": "Alex",
    "identities": [
      {
        "user_id": "49f1d275-9d00-4f90-bab9-fbe14781a778",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "alexkhoroshko20@gmail.com",
    "nickname": "alexkhoroshko20",
    "picture": "https://s.gravatar.com/avatar/f45ae856b784dcc62b9104cea127efcb?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fal.png",
    "updated_at": "2020-11-12T17:09:53.281Z",
    "user_id": "auth0|49f1d275-9d00-4f90-bab9-fbe14781a778",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-DE;q=0.8,ru-DE;q=0.6,en-US;q=0.4,uk-UA;q=0.2",
      "person_id": "0e065238f9612125cb25e6b0e899278fcper"
    },
    "last_login": "2020-11-12T17:09:53.281Z",
    "last_ip": "3.121.63.70",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-12T08:53:26.586Z",
    "email": "joe.latt+004@engelvoelkers.com",
    "email_verified": true,
    "family_name": "Latt",
    "given_name": "Joe",
    "identities": [
      {
        "user_id": "28aa1053-a8e7-4dd7-8eb0-0c7e99c8c4c3",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "joe.latt+004@engelvoelkers.com",
    "nickname": "joe.latt+004",
    "picture": "https://s.gravatar.com/avatar/1472dfd528cf8cb33c3314545c16850a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fjo.png",
    "updated_at": "2020-11-12T09:15:10.860Z",
    "user_id": "auth0|28aa1053-a8e7-4dd7-8eb0-0c7e99c8c4c3",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-GB;q=0.5",
      "person_id": "199f6114d58ad95b6c3df3e2d7dd05e9cper"
    },
    "last_login": "2020-11-12T09:15:10.859Z",
    "last_ip": "3.121.63.70",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-12T08:48:19.392Z",
    "email": "joe.latt#003@engelvoelkers.com",
    "email_verified": false,
    "family_name": "Latt",
    "given_name": "Joe",
    "identities": [
      {
        "user_id": "a10d7aa0-786a-4fc5-826a-ce5b2d3f09bf",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "joe.latt#003@engelvoelkers.com",
    "nickname": "joe.latt#003",
    "picture": "https://s.gravatar.com/avatar/263fe48c3c545c8c4fe788274f6fc05b?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fjo.png",
    "updated_at": "2020-11-12T08:48:21.994Z",
    "user_id": "auth0|a10d7aa0-786a-4fc5-826a-ce5b2d3f09bf",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-GB;q=0.5"
    },
    "last_login": "2020-11-12T08:48:21.994Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-10T15:17:45.498Z",
    "email": "ersin.isimtekin@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "9c66a88f-a001-4cfd-a9cb-8fede3e0c28e",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "ersin.isimtekin@finbyte.com",
    "nickname": "ersin.isimtekin",
    "picture": "https://s.gravatar.com/avatar/23de64a0652c4dd2b00341f513c30cdf?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fer.png",
    "updated_at": "2020-12-02T16:25:19.413Z",
    "user_id": "auth0|9c66a88f-a001-4cfd-a9cb-8fede3e0c28e",
    "last_login": "2020-12-02T16:25:19.413Z",
    "last_ip": "2003:c3:ff32:cae2:d9ec:4dde:cbc3:cef4",
    "logins_count": 53
  },
  {
    "created_at": "2020-11-10T12:15:50.356Z",
    "email": "roman.smigiel+wealth004@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "93a9f492-b970-44b3-88be-c2249bc92b1f",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+wealth004@weisshausinvestment.com",
    "nickname": "roman.smigiel+wealth004",
    "picture": "https://s.gravatar.com/avatar/a8a4f5857a79d97f460eb3784ade9e03?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-12-01T12:50:19.618Z",
    "user_id": "auth0|93a9f492-b970-44b3-88be-c2249bc92b1f",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding",
      "phoneNumber": "123"
    },
    "last_login": "2020-12-01T12:50:19.618Z",
    "last_ip": "2a02:8109:8a00:6184:dab:74b8:be15:1638",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-10T10:52:57.417Z",
    "email": "andre.poetter@outlook.de",
    "email_verified": true,
    "family_name": "Pötter",
    "given_name": "Andre",
    "identities": [
      {
        "user_id": "d1ece42a-4114-4d3d-b803-1cc0b97dd147",
        "provider": "auth0",
        "connection": "ev-prod-identity-store",
        "isSocial": false
      }
    ],
    "name": "andre.poetter@outlook.de",
    "nickname": "andre.poetter",
    "picture": "https://s.gravatar.com/avatar/d0a88900bdb191e179648ca650a6930a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fan.png",
    "updated_at": "2020-12-01T16:06:56.394Z",
    "user_id": "auth0|d1ece42a-4114-4d3d-b803-1cc0b97dd147",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE",
      "person_id": "86c7d468935ca2c9854071919591a1a6cper"
    },
    "last_login": "2020-12-01T16:06:56.393Z",
    "last_ip": "18.156.132.104",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-09T09:22:09.895Z",
    "email": "gemma.pinyol+85ev@finleap.com",
    "email_verified": true,
    "family_name": "Moon",
    "given_name": "Ashraf",
    "identities": [
      {
        "user_id": "4b7c0a51-c76f-4629-b308-47ea5119ba54",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+85ev@finleap.com",
    "nickname": "gemma.pinyol+85ev",
    "picture": "https://s.gravatar.com/avatar/f466eff64748ba10f9f0ca4af6411b48?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-26T18:03:32.207Z",
    "user_id": "auth0|4b7c0a51-c76f-4629-b308-47ea5119ba54",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-US,de-US;q=0.5",
      "person_id": "64ed0f3d193ec31735869bb4efb6da92cper"
    },
    "last_login": "2020-11-26T18:03:32.206Z",
    "last_ip": "3.121.63.70",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-09T09:21:32.588Z",
    "email": "franziska.brendel+205@finleap.com",
    "email_verified": true,
    "family_name": "Brendel",
    "given_name": "Franzi",
    "identities": [
      {
        "user_id": "d2db945a-5165-4e25-9ce0-a54da6bf8873",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "franziska.brendel+205@finleap.com",
    "nickname": "franziska.brendel+205",
    "picture": "https://s.gravatar.com/avatar/4bdd64f420cafd021ad23f50588a9698?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-11-19T15:52:37.028Z",
    "user_id": "auth0|d2db945a-5165-4e25-9ce0-a54da6bf8873",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.86,es-UN;q=0.71,en-GB;q=0.57,pt-BR;q=0.43,ja-DE;q=0.29,zh-Hans-DE;q=0.14",
      "person_id": "8f7bff68be092a4805b3009948b72a8fcper"
    },
    "last_login": "2020-11-19T15:52:37.028Z",
    "last_ip": "52.29.11.71",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-07T16:59:44.088Z",
    "email": "kia-hsing.tung@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Tung",
    "given_name": "Kia-Hsing",
    "identities": [
      {
        "user_id": "c087c1a8-e86a-4758-849a-45bd066ea65a",
        "provider": "auth0",
        "connection": "ev-prod-identity-store",
        "isSocial": false
      }
    ],
    "name": "kia-hsing.tung@weisshausinvestment.com",
    "nickname": "kia-hsing.tung",
    "picture": "https://s.gravatar.com/avatar/1b8a07c6f64a709622affa0ab12d02b5?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fki.png",
    "updated_at": "2020-11-07T17:06:58.726Z",
    "user_id": "auth0|c087c1a8-e86a-4758-849a-45bd066ea65a",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-GB;q=0.5",
      "person_id": "c978c5ff13d158031d125d245b660114cper"
    },
    "last_login": "2020-11-07T16:59:45.504Z",
    "last_ip": "18.157.89.67",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-06T17:09:28.866Z",
    "email": "gemma.pinyol+84ev@finleap.com",
    "email_verified": true,
    "family_name": "Bravo",
    "given_name": "Riley",
    "identities": [
      {
        "user_id": "78fa30c3-cc55-421a-8a7d-bd37f5b6462c",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+84ev@finleap.com",
    "nickname": "gemma.pinyol+84ev",
    "picture": "https://s.gravatar.com/avatar/fe5fd2b8ee1d6f92504d5c87a2d9a2c2?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-19T07:10:07.524Z",
    "user_id": "auth0|78fa30c3-cc55-421a-8a7d-bd37f5b6462c",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-ES;q=0.75,en-GB;q=0.5,ca-ES;q=0.25",
      "person_id": "fb73a385478c63db65c46bd8ff814c61cper"
    },
    "last_login": "2020-11-19T07:10:07.523Z",
    "last_ip": "3.121.63.70",
    "logins_count": 4
  },
  {
    "created_at": "2020-11-06T14:19:30.952Z",
    "email": "gemma.pinyol+83ev@finleap.com",
    "email_verified": true,
    "family_name": "Sadler",
    "given_name": "Antonia",
    "identities": [
      {
        "user_id": "ffdb46e0-835a-4683-afd1-a4c70c683f70",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+83ev@finleap.com",
    "nickname": "gemma.pinyol+83ev",
    "picture": "https://s.gravatar.com/avatar/cb7ca177ecc0c282681ae0b759f4a576?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-19T07:10:37.683Z",
    "user_id": "auth0|ffdb46e0-835a-4683-afd1-a4c70c683f70",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,es-ES;q=0.75,en-GB;q=0.5,ca-ES;q=0.25",
      "person_id": "b36b949a3529b6e22be65b681a53f705cper"
    },
    "last_login": "2020-11-19T07:10:37.682Z",
    "last_ip": "3.121.63.70",
    "logins_count": 4
  },
  {
    "created_at": "2020-11-06T14:13:38.878Z",
    "email": "gemma.pinyol+82ev@finleap.com",
    "email_verified": true,
    "family_name": "Sanders",
    "given_name": "Kyra",
    "identities": [
      {
        "user_id": "d7612b25-c3d7-4836-8d49-bb0284fed215",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+82ev@finleap.com",
    "nickname": "gemma.pinyol+82ev",
    "picture": "https://s.gravatar.com/avatar/c47b43ae548cfb9c38549c9dc24aa1ce?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-12-02T10:18:05.478Z",
    "user_id": "auth0|d7612b25-c3d7-4836-8d49-bb0284fed215",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-GB,es-ES;q=0.67,de-DE;q=0.33",
      "person_id": "23330b54e0ffa27f9e73a2e49c534321cper"
    },
    "last_login": "2020-12-02T10:18:05.478Z",
    "last_ip": "52.29.11.71",
    "logins_count": 10
  },
  {
    "created_at": "2020-11-06T14:07:21.049Z",
    "email": "gemma.pinyol+81ev@finleap.com",
    "email_verified": true,
    "family_name": "Mccarthy",
    "given_name": "Katy",
    "identities": [
      {
        "user_id": "6dbb3529-5119-4e4f-8da3-e75b5ecd96b4",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+81ev@finleap.com",
    "nickname": "gemma.pinyol+81ev",
    "picture": "https://s.gravatar.com/avatar/71ce12014f15382374432da836cce855?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-10T08:56:29.361Z",
    "user_id": "auth0|6dbb3529-5119-4e4f-8da3-e75b5ecd96b4",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-AQ,en-AQ;q=0.75,es-AQ;q=0.5,fr-AQ;q=0.25",
      "person_id": "9c0ba820ee2db7594364c2086f5cbc43cper"
    },
    "last_login": "2020-11-06T14:07:22.504Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-06T08:35:35.715Z",
    "email": "roman.smigiel+testflight008@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "7ecf0fb1-067b-43db-ab84-e0606cd6f8db",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+testflight008@weisshausinvestment.com",
    "nickname": "roman.smigiel+testflight008",
    "picture": "https://s.gravatar.com/avatar/9edff313fb90b944f2ea7509c6909078?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-11-06T08:36:46.186Z",
    "user_id": "auth0|7ecf0fb1-067b-43db-ab84-e0606cd6f8db",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-US,de-US;q=0.67,pl-US;q=0.33",
      "person_id": "c6f0956c758726a543f87d19a360aadccper"
    },
    "last_login": "2020-11-06T08:35:36.726Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-05T15:48:38.454Z",
    "email": "franziska.brendel+204@finleap.com",
    "email_verified": true,
    "family_name": "Brendel",
    "given_name": "Franziska",
    "identities": [
      {
        "user_id": "07435639-08e0-423d-9c4b-4fad3b22cf6e",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "franziska.brendel+204@finleap.com",
    "nickname": "franziska.brendel+204",
    "picture": "https://s.gravatar.com/avatar/f717febd226c078b28416857b91ddf5e?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-11-05T15:50:07.973Z",
    "user_id": "auth0|07435639-08e0-423d-9c4b-4fad3b22cf6e",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.86,es-UN;q=0.71,en-GB;q=0.57,pt-BR;q=0.43,ja-DE;q=0.29,zh-Hans-DE;q=0.14",
      "person_id": "03852002049d3395938382e779bb8760cper"
    },
    "last_login": "2020-11-05T15:48:39.165Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-05T11:29:12.499Z",
    "email": "gareth.fox+15@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "Fox",
    "given_name": "Gareth",
    "identities": [
      {
        "user_id": "9d7ee1c6-2cf8-42f6-9ceb-30a5bf2770b7",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gareth.fox+15@weisshausinvestment.com",
    "nickname": "gareth.fox+15",
    "picture": "https://s.gravatar.com/avatar/bc3887c64377d241399ee42161c05e03?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fga.png",
    "updated_at": "2020-12-03T21:01:40.632Z",
    "user_id": "auth0|9d7ee1c6-2cf8-42f6-9ceb-30a5bf2770b7",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-GB,en-GB;q=0.5",
      "person_id": "aaaff0251cf69cfff28d771b5f9b0a40cper"
    },
    "last_login": "2020-12-03T21:01:40.632Z",
    "last_ip": "77.189.167.135",
    "logins_count": 25
  },
  {
    "created_at": "2020-11-05T10:52:22.771Z",
    "email": "ersin.isimtekin+login@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "24f35977-979e-4f0f-945a-79980ab15db5",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "ersin.isimtekin+login@finbyte.com",
    "nickname": "ersin.isimtekin+login",
    "picture": "https://s.gravatar.com/avatar/d33094c0c9ef1be4e9746010feddb925?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fer.png",
    "updated_at": "2020-11-10T15:06:50.230Z",
    "user_id": "auth0|24f35977-979e-4f0f-945a-79980ab15db5",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-11-10T15:06:50.229Z",
    "last_ip": "2003:c3:ff10:3c55:c134:1a1:783c:1516",
    "logins_count": 4
  },
  {
    "created_at": "2020-11-05T10:24:06.979Z",
    "email": "roman.smigiel+wealth003@weisshausinvestment.com",
    "email_verified": false,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "872976bc-bd94-4734-9643-2244fd9a279d",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "R S",
    "nickname": "roman.smigiel+wealth003",
    "picture": "https://s.gravatar.com/avatar/b4c3636e241cc27c5792a9c28b2cd6a5?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Frs.png",
    "updated_at": "2020-11-05T10:24:06.979Z",
    "user_id": "auth0|872976bc-bd94-4734-9643-2244fd9a279d",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T12:19:39.680Z",
    "email": "frank.kebsch@gmail.com",
    "email_verified": true,
    "family_name": "Kebsch",
    "given_name": "Frank",
    "identities": [
      {
        "user_id": "3fed4429-1e40-4a5c-b9db-a520ac15ff8d",
        "provider": "auth0",
        "connection": "ev-prod-identity-store",
        "isSocial": false
      }
    ],
    "name": "frank.kebsch@gmail.com",
    "nickname": "frank.kebsch",
    "picture": "https://s.gravatar.com/avatar/1049ce597f9847e673016dd40cad9d95?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-11-28T09:51:57.259Z",
    "user_id": "auth0|3fed4429-1e40-4a5c-b9db-a520ac15ff8d",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.5",
      "person_id": "2c700ea8c21238be48a5cf5b3891c023cper"
    },
    "last_login": "2020-11-28T09:51:57.259Z",
    "last_ip": "18.157.89.67",
    "logins_count": 3
  },
  {
    "created_at": "2020-11-04T11:41:59.378Z",
    "email": "ersin.isimtekin+whi-8@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "430f4982-8ce0-4c6c-bd46-226288777ebc",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-8",
    "picture": "https://s.gravatar.com/avatar/530cea8984ac111f5f7e1578d364836a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T11:41:59.378Z",
    "user_id": "auth0|430f4982-8ce0-4c6c-bd46-226288777ebc",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T11:10:34.363Z",
    "email": "roman.smigiel+wealth002@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "f42134a4-0f4b-4e37-9326-e89b1ef31e2f",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "roman.smigiel+wealth002@weisshausinvestment.com",
    "nickname": "roman.smigiel+wealth002",
    "picture": "https://s.gravatar.com/avatar/6dd68b94e40dfa59b5b4927354650d88?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fro.png",
    "updated_at": "2020-11-30T18:33:51.738Z",
    "user_id": "auth0|f42134a4-0f4b-4e37-9326-e89b1ef31e2f",
    "user_metadata": {
      "lang": "de",
      "application": "whi-onboarding"
    },
    "last_login": "2020-11-30T18:33:51.736Z",
    "last_ip": "2a02:8109:8a00:6184:d921:628a:9426:2eec",
    "logins_count": 2
  },
  {
    "created_at": "2020-11-04T10:27:17.261Z",
    "email": "gemma.pinyol+80ev@finleap.com",
    "email_verified": true,
    "family_name": "Herbert",
    "given_name": "Barry",
    "identities": [
      {
        "user_id": "5ef316fb-d4cf-4e05-817a-c2cc8d297e0c",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+80ev@finleap.com",
    "nickname": "gemma.pinyol+80ev",
    "picture": "https://s.gravatar.com/avatar/7c3a0d82263c6adef5cad6cd47356b7d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-04T10:28:34.105Z",
    "user_id": "auth0|5ef316fb-d4cf-4e05-817a-c2cc8d297e0c",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-US,de-US;q=0.5",
      "person_id": "4c3d93a5a1b5e78d88b3b02b8defa880cper"
    },
    "last_login": "2020-11-04T10:27:18.080Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-04T09:37:19.291Z",
    "email": "gemma.pinyol+79ev@finleap.com",
    "email_verified": true,
    "family_name": "Edwards",
    "given_name": "Rhiannon",
    "identities": [
      {
        "user_id": "64a49ca4-f681-4a49-b499-630626407d0d",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+79ev@finleap.com",
    "nickname": "gemma.pinyol+79ev",
    "picture": "https://s.gravatar.com/avatar/3d668797e3255898e1b87a9c86c3404b?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-24T16:20:04.810Z",
    "user_id": "auth0|64a49ca4-f681-4a49-b499-630626407d0d",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-AQ,en-AQ;q=0.75,es-AQ;q=0.5,fr-AQ;q=0.25",
      "person_id": "6292e7ac053e20fae4d76a4475465bbccper"
    },
    "last_login": "2020-11-24T16:20:04.810Z",
    "last_ip": "52.29.11.71",
    "logins_count": 4
  },
  {
    "created_at": "2020-11-04T09:32:06.138Z",
    "email": "franziska.brendel+203@finleap.com",
    "email_verified": true,
    "family_name": "Brendel",
    "given_name": "Franziska",
    "identities": [
      {
        "user_id": "147d8837-f45e-4e2a-99db-9877a7050856",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "franziska.brendel+203@finleap.com",
    "nickname": "franziska.brendel+203",
    "picture": "https://s.gravatar.com/avatar/5bfa631409866e4c9f6997c3224ca598?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-11-04T09:49:17.947Z",
    "user_id": "auth0|147d8837-f45e-4e2a-99db-9877a7050856",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.86,es-UN;q=0.71,en-GB;q=0.57,pt-BR;q=0.43,ja-DE;q=0.29,zh-Hans-DE;q=0.14",
      "person_id": "fae07a3b0ff2d531cd75c2053a64139bcper"
    },
    "last_login": "2020-11-04T09:32:08.768Z",
    "last_ip": "52.29.11.71",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-04T09:02:39.047Z",
    "email": "ersin.isimtekin+whi-7@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "18cd33f5-7d88-454a-a0e4-e8ad3ae0550c",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-7",
    "picture": "https://s.gravatar.com/avatar/c81260b9b014f9cd29ea78310a13e240?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T09:02:51.278Z",
    "user_id": "auth0|18cd33f5-7d88-454a-a0e4-e8ad3ae0550c",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T09:00:09.561Z",
    "email": "ersin.isimtekin+whi-6@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "379b95a0-6112-482b-9685-be1343d91869",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-6",
    "picture": "https://s.gravatar.com/avatar/2fb6bf81a788814b649af3ba2801d4a6?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T09:00:21.784Z",
    "user_id": "auth0|379b95a0-6112-482b-9685-be1343d91869",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T08:59:07.914Z",
    "email": "gemma.pinyol+78ev@finleap.com",
    "email_verified": true,
    "family_name": "Valenzuela",
    "given_name": "Nishat",
    "identities": [
      {
        "user_id": "9773b5f1-6842-4e96-9a22-df655b352565",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "gemma.pinyol+78ev@finleap.com",
    "nickname": "gemma.pinyol+78ev",
    "picture": "https://s.gravatar.com/avatar/d333ab5d412c3fc2672eabf50ced6557?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fge.png",
    "updated_at": "2020-11-13T10:10:27.447Z",
    "user_id": "auth0|9773b5f1-6842-4e96-9a22-df655b352565",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-US",
      "person_id": "e872de8ba5d1a43053a87855062f1172cper"
    },
    "last_login": "2020-11-13T10:10:27.446Z",
    "last_ip": "52.29.11.71",
    "logins_count": 4
  },
  {
    "created_at": "2020-11-04T08:58:56.410Z",
    "email": "ersin.isimtekin+whi-5@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "647a8cda-3137-4bc9-90f2-f2f41e754143",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-5",
    "picture": "https://s.gravatar.com/avatar/2ab01f14ceccf63ed4d0e8b955089f23?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T08:59:05.691Z",
    "user_id": "auth0|647a8cda-3137-4bc9-90f2-f2f41e754143",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T08:56:12.053Z",
    "email": "ersin.isimtekin+whi-4@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "8c82c36b-de4f-4b5b-a06f-2ff1d456bdda",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-4",
    "picture": "https://s.gravatar.com/avatar/556392504cbb9f7201bffbb4eacb2779?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T08:56:23.046Z",
    "user_id": "auth0|8c82c36b-de4f-4b5b-a06f-2ff1d456bdda",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T08:52:03.189Z",
    "email": "ersin.isimtekin+whi-3@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "2599be46-fec0-48c6-a96b-3e2850c6e045",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-3",
    "picture": "https://s.gravatar.com/avatar/4e01d034d3ee946d972a0b897ff7674d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T08:52:42.841Z",
    "user_id": "auth0|2599be46-fec0-48c6-a96b-3e2850c6e045",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T08:50:17.337Z",
    "email": "ersin.isimtekin+whi-2@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "086c928e-52cf-4126-8473-94c1b8ac9f58",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-2",
    "picture": "https://s.gravatar.com/avatar/75e15f5d87fa137e132e337f82cfbe0f?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T08:50:38.348Z",
    "user_id": "auth0|086c928e-52cf-4126-8473-94c1b8ac9f58",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-04T08:45:47.397Z",
    "email": "ersin.isimtekin+whi-1@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "02737710-dda6-4d23-9944-3148568dc1e0",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi-1",
    "picture": "https://s.gravatar.com/avatar/412d7a5c1033b01bcf28a114d098849e?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T08:46:09.787Z",
    "user_id": "auth0|02737710-dda6-4d23-9944-3148568dc1e0",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-03T17:13:15.468Z",
    "email": "franziska.brendel+202@finleap.com",
    "email_verified": true,
    "family_name": "Brendel",
    "given_name": "Franziska",
    "identities": [
      {
        "user_id": "1e7cd58f-2ddc-43ec-bed0-867d2be697ac",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "franziska.brendel+202@finleap.com",
    "nickname": "franziska.brendel+202",
    "picture": "https://s.gravatar.com/avatar/d63f7302e0e62dc9d730dbe27f41bb4f?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-11-03T17:14:21.419Z",
    "user_id": "auth0|1e7cd58f-2ddc-43ec-bed0-867d2be697ac",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.86,es-UN;q=0.71,en-GB;q=0.57,pt-BR;q=0.43,ja-DE;q=0.29,zh-Hans-DE;q=0.14",
      "person_id": "c7743f67a125132be39580987502f90ecper"
    },
    "last_login": "2020-11-03T17:13:16.222Z",
    "last_ip": "3.121.63.70",
    "logins_count": 1
  },
  {
    "created_at": "2020-11-03T15:42:04.592Z",
    "email": "ersin.isimtekin+whi4@finbyte.com",
    "email_verified": true,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "1853fc68-a6e7-4dff-9867-45eb88e44fca",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi4",
    "picture": "https://s.gravatar.com/avatar/af71502bef94b147e0c010457686bd91?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-04T08:46:41.332Z",
    "user_id": "auth0|1853fc68-a6e7-4dff-9867-45eb88e44fca",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-03T15:35:56.605Z",
    "email": "ersin.isimtekin+whi3@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "55c85c3a-1047-415e-a0a2-c1eeb33ced3d",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi3",
    "picture": "https://s.gravatar.com/avatar/c4e1a079a0c8c215c06c2ced8447f698?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-03T15:35:56.606Z",
    "user_id": "auth0|55c85c3a-1047-415e-a0a2-c1eeb33ced3d",
    "user_metadata": {
      "lang": "en",
      "application": "whi-onboarding"
    }
  },
  {
    "created_at": "2020-11-03T15:33:50.481Z",
    "email": "ersin.isimtekin+whi2@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "cc688349-ef11-444c-9196-8c9e0d08f2a4",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi2",
    "picture": "https://s.gravatar.com/avatar/64061d1515cc5e0ca79868e5eaae8744?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-03T15:33:50.481Z",
    "user_id": "auth0|cc688349-ef11-444c-9196-8c9e0d08f2a4"
  },
  {
    "created_at": "2020-11-03T13:58:01.442Z",
    "email": "ersin.isimtekin+whi1@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "7588031f-a06d-4bbc-9da4-f65916ce8aa2",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi1",
    "picture": "https://s.gravatar.com/avatar/2d0b596e94beba7dfa5cd9f261b46633?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-03T13:58:01.442Z",
    "user_id": "auth0|7588031f-a06d-4bbc-9da4-f65916ce8aa2",
    "user_metadata": {
      "phoneNumber": "1525123123123"
    }
  },
  {
    "created_at": "2020-11-03T13:57:23.422Z",
    "email": "ersin.isimtekin+whi@finbyte.com",
    "email_verified": false,
    "family_name": "Isimtekin",
    "given_name": "Ersin",
    "identities": [
      {
        "user_id": "8f48d033-073d-4039-98db-3b0854f873ca",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Ersin Isimtekin",
    "nickname": "ersin.isimtekin+whi",
    "picture": "https://s.gravatar.com/avatar/8eaf988f31690e5c49f164b04603119f?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fei.png",
    "updated_at": "2020-11-03T13:57:23.422Z",
    "user_id": "auth0|8f48d033-073d-4039-98db-3b0854f873ca"
  },
  {
    "created_at": "2020-11-02T16:59:38.353Z",
    "email": "justus.hageboelling@gmail.com",
    "email_verified": true,
    "family_name": "Hagebölling",
    "given_name": "Justus",
    "identities": [
      {
        "user_id": "bc6a5c39-6cef-42d2-b770-013a4496a4c7",
        "provider": "auth0",
        "connection": "ev-prod-identity-store",
        "isSocial": false
      }
    ],
    "name": "justus.hageboelling@gmail.com",
    "nickname": "justus.hageboelling",
    "picture": "https://s.gravatar.com/avatar/b0194f1ca3c660d5d35eadcf6c2a01b9?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fju.png",
    "updated_at": "2020-12-04T22:37:03.846Z",
    "user_id": "auth0|bc6a5c39-6cef-42d2-b770-013a4496a4c7",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "en-DE,de-DE;q=0.5",
      "person_id": "a594845dbcf48219433157489aeca726cper"
    },
    "last_login": "2020-12-04T22:37:03.845Z",
    "last_ip": "18.157.89.67",
    "logins_count": 5
  },
  {
    "created_at": "2020-11-02T09:56:39.058Z",
    "email": "franziska.brendel+201@finleap.com",
    "email_verified": true,
    "family_name": "Brendel",
    "given_name": "Franziska",
    "identities": [
      {
        "user_id": "eec598ff-0d34-48a7-b9b2-d101d809c459",
        "provider": "auth0",
        "connection": "ev-sandbox-identity-store",
        "isSocial": false
      }
    ],
    "name": "franziska.brendel+201@finleap.com",
    "nickname": "franziska.brendel+201",
    "picture": "https://s.gravatar.com/avatar/ad26e6307baca02b293f4f07da6e1007?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Ffr.png",
    "updated_at": "2020-11-04T07:28:47.064Z",
    "user_id": "auth0|eec598ff-0d34-48a7-b9b2-d101d809c459",
    "user_metadata": {
      "invitation_code": "evwfamily",
      "language": "de-DE,en-DE;q=0.86,es-UN;q=0.71,en-GB;q=0.57,pt-BR;q=0.43,ja-DE;q=0.29,zh-Hans-DE;q=0.14",
      "person_id": "ecb488b20b5f5b9536ce31521f7caffecper"
    },
    "last_login": "2020-11-04T07:28:47.064Z",
    "last_ip": "52.29.11.71",
    "logins_count": 2
  },
  {
    "created_at": "2020-10-30T13:40:44.553Z",
    "email": "roman.smigiel+wealth001@weisshausinvestment.com",
    "email_verified": true,
    "family_name": "S",
    "given_name": "R",
    "identities": [
      {
        "user_id": "ff673419-87b1-457a-ac8b-7f52264174b0",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "R S",
    "nickname": "roman.smigiel+wealth001",
    "picture": "https://s.gravatar.com/avatar/20a649c3e36a8eea34d242e7b12d2b6d?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Frs.png",
    "updated_at": "2020-10-30T13:43:12.040Z",
    "user_id": "auth0|ff673419-87b1-457a-ac8b-7f52264174b0",
    "user_metadata": {
      "phoneNumber": "1"
    }
  },
  {
    "created_at": "2020-10-30T13:35:41.365Z",
    "email": "sebastian.weikart+1231212@finleap.com",
    "email_verified": true,
    "family_name": "Weikart",
    "given_name": "Sebastian",
    "identities": [
      {
        "user_id": "f2e5cc90-b472-4a5c-9d2e-1fa4848f6680",
        "connection": "ev-sandbox-identity-store",
        "provider": "auth0",
        "isSocial": false
      }
    ],
    "name": "Sebastian Weikart",
    "nickname": "sebastian.weikart+1231212",
    "picture": "https://s.gravatar.com/avatar/b69b3040598c987120ecd6c05a9d136a?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fsw.png",
    "updated_at": "2020-10-30T13:41:13.371Z",
    "user_id": "auth0|f2e5cc90-b472-4a5c-9d2e-1fa4848f6680",
    "user_metadata": {
      "phoneNumber": "015290068232"
    }
  }
]


     */


}
