# Eclappse - Back-End

O projeto foi mantido na arquitetura original (Entity / Repository / Service / Controller) e alinhado ao SQL do TCC.

## Principais rotas
- `GET/POST /api/v1/usuarios`
- `GET /api/v1/usuarios/{id}`
- `PUT/DELETE /api/v1/usuarios/{id}`
- `GET/POST /api/v1/casos`
- `GET /api/v1/casos/{id}`
- `GET /api/v1/casos/status/{status}`
- `GET/POST /api/v1/avistamentos`
- `GET /api/v1/avistamentos/caso/{casoId}`
- `GET /api/v1/avistamentos/status/{status}`
- `GET/POST /api/v1/favoritos`
- `GET /api/v1/favoritos/usuario/{usuarioId}`
- `GET/POST /api/v1/historico-casos`
- `GET /api/v1/historico-casos/caso/{casoId}`
- `GET/POST /api/v1/moderacao-conteudo`
- `GET /api/v1/moderacao-conteudo/status/{status}`
- `GET/POST /api/v1/notificacoes`
- `GET /api/v1/notificacoes/usuario/{usuarioId}`
- `GET /api/v1/notificacoes/usuario/{usuarioId}/nao-lidas`
- `GET/POST /api/v1/penalidades`
- `GET /api/v1/penalidades/usuario/{usuarioId}`
- `GET/POST /api/v1/auditoria`
- `GET /api/v1/auditoria/usuario/{usuarioId}`

## Observação
O login/autenticação não foi inventado nesta correção. O projeto original ainda não possuía uma camada de autenticação implementada; ela pode ser adicionada depois, quando o Front-End estiver sendo integrado.
