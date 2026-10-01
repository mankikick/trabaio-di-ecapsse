USE master;
GO

-- 1. RECRIA O BANCO SE ELE JÁ EXISTIR
IF EXISTS(SELECT * FROM sys.databases WHERE name='bd_eclappse') 
	DROP DATABASE bd_eclappse;
GO 

-- 2. CRIAÇÃO E SELEÇÃO DO BANCO
CREATE DATABASE bd_eclappse;
GO

USE bd_eclappse;
GO



-- Tabela para Gerenciar Usuários, Autenticação e Perfis
CREATE TABLE Usuario (
	id					INT				IDENTITY(1,1),
	nome				VARCHAR(100)	NOT NULL,
	email				VARCHAR(100)	NOT NULL UNIQUE,
	username			VARCHAR(100)	NOT NULL UNIQUE,
	password			VARCHAR(255)	NOT NULL,
	cpf					CHAR(11)			NULL UNIQUE,
	telefone			VARCHAR(20)			NULL,
	foto				VARBINARY(MAX)		NULL,
	perfil				VARCHAR(30)		NOT NULL, -- Visitante, Responsável, Colaborador, Administrador
	status_conta		VARCHAR(20)		NOT NULL DEFAULT 'ATIVO',
	token_confirmacao	VARCHAR(255)		NULL,
	token_recuperacao	VARCHAR(255)		NULL,
	expiracao_token		DATETIME2			NULL,
	data_cadastro		DATETIME2		NOT NULL DEFAULT SYSDATETIME(),
	data_atualizacao	DATETIME2			NULL,

	PRIMARY KEY (id),
	CONSTRAINT CK_Perfil_Usuario CHECK (perfil IN ('VISITANTE', 'RESPONSAVEL', 'COLABORADOR', 'ADMINISTRADOR')),
	CONSTRAINT CK_Status_Conta   CHECK (status_conta IN ('PENDENTE', 'ATIVO', 'SUSPENSO', 'BANIDO', 'BLOQUEADO'))
);
GO

SELECT * FROM Usuario

-- Tabela para Cadastrar e Gerenciar Casos de Desaparecidos
CREATE TABLE Caso (
	id						INT				IDENTITY(1,1),
	usuario_responsavel_id	INT				NOT NULL, -- Usuário (Responsável / Familiar)
	nome_desaparecido		VARCHAR(100)	NOT NULL,
	data_nascimento			DATE				NULL,
	data_desaparecimento	DATE			NOT NULL,
	local_desaparecimento	VARCHAR(255)	NOT NULL,
	caracteristicas_fisicas	VARCHAR(MAX)		NULL,
	circunstancias			VARCHAR(MAX)		NULL,
	foto					VARBINARY(MAX)		NULL,
	status_caso				VARCHAR(30)		NOT NULL DEFAULT 'ATIVO',
	solicitacao_exclusao	BIT				NOT NULL DEFAULT 0, -- Regra para Solicitar Exclusão
	motivo_exclusao			VARCHAR(MAX)		NULL,
	data_registro			DATETIME2		NOT NULL DEFAULT SYSDATETIME(),
	data_atualizacao		DATETIME2			NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (usuario_responsavel_id) REFERENCES Usuario (id),
	CONSTRAINT CK_Status_Caso CHECK (status_caso IN ('ATIVO', 'ENCERRADO', 'ARQUIVADO', 'SOLICITADO_EXCLUSAO'))
);
GO

SELECT * FROM Caso

-- Tabela de Histórico do Caso (Mudanças de status, atualizações)
CREATE TABLE HistoricoCaso (
	id					INT				IDENTITY(1,1),
	caso_id				INT				NOT NULL,
	usuario_id			INT				NOT NULL,
	status_anterior		VARCHAR(30)		NOT NULL,
	status_novo			VARCHAR(30)		NOT NULL,
	descricao_alteracao	VARCHAR(MAX)	NOT NULL,
	data_registro		DATETIME2		NOT NULL DEFAULT SYSDATETIME(),

	PRIMARY KEY (id),
	FOREIGN KEY (caso_id) REFERENCES Caso (id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario (id)
);
GO

-- Tabela para Registrar Avistamento (Colaborador Cidadão)
CREATE TABLE Avistamento (
	id						INT				IDENTITY(1,1),
	caso_id					INT				NOT NULL,
	colaborador_id			INT				NOT NULL, -- Colaborador (Cidadão)
	data_avistamento		DATETIME2		NOT NULL,
	descricao_detalhada		VARCHAR(MAX)	NOT NULL,
	
	-- Dados de Localização do Avistamento
	logradouro				VARCHAR(100)	NOT NULL,
	numero					VARCHAR(10)			NULL,
	bairro					VARCHAR(100)	NOT NULL,
	cidade					VARCHAR(100)	NOT NULL,
	uf						CHAR(2)			NOT NULL,
	cep						CHAR(8)				NULL,
	ponto_referencia		VARCHAR(100)		NULL,
	latitude				VARCHAR(100)		NULL,
	longitude				VARCHAR(100)		NULL,

	foto_evidencia			VARBINARY(MAX)		NULL,
	status_avistamento		VARCHAR(20)		NOT NULL DEFAULT 'EM_ANALISE',
	data_registro			DATETIME2		NOT NULL DEFAULT SYSDATETIME(),

	PRIMARY KEY (id),
	FOREIGN KEY (caso_id) REFERENCES Caso (id),
	FOREIGN KEY (colaborador_id) REFERENCES Usuario (id),
	CONSTRAINT CK_Status_Avistamento CHECK (status_avistamento IN ('EM_ANALISE', 'VALIDADO', 'REJEITADO'))
);
GO

SELECT * FROM Avistamento

-- Tabela do Processo Automático: Notificar Responsável
CREATE TABLE Notificacao (
	id						INT				IDENTITY(1,1),
	usuario_destino_id		INT				NOT NULL, -- Responsável que recebe a notificação
	caso_id					INT				NOT NULL,
	titulo					VARCHAR(100)	NOT NULL,
	mensagem				VARCHAR(500)	NOT NULL,
	lida					BIT				NOT NULL DEFAULT 0,
	data_envio				DATETIME2		NOT NULL DEFAULT SYSDATETIME(),

	PRIMARY KEY (id),
	FOREIGN KEY (usuario_destino_id) REFERENCES Usuario (id),
	FOREIGN KEY (caso_id) REFERENCES Caso (id)
);
GO

SELECT * FROM Notificacao

-- Tabela para Moderar Conteúdo (Comentários / Denúncias)
CREATE TABLE ModeraçãoConteudo (
	id					INT				IDENTITY(1,1),
	caso_id				INT				NOT NULL,
	usuario_autor_id	INT				NOT NULL,
	conteudo_texto		VARCHAR(1000)	NOT NULL,
	status_conteudo		VARCHAR(20)		NOT NULL DEFAULT 'EM_ANALISE', -- Aprovado, Oculto, Denunciado
	motivo_denuncia		VARCHAR(255)		NULL,
	data_criacao		DATETIME2		NOT NULL DEFAULT SYSDATETIME(),

	PRIMARY KEY (id),
	FOREIGN KEY (caso_id) REFERENCES Caso (id),
	FOREIGN KEY (usuario_autor_id) REFERENCES Usuario (id),
	CONSTRAINT CK_Status_Conteudo CHECK (status_conteudo IN ('EM_ANALISE', 'APROVADO', 'OCULTO', 'DENUNCIADO'))
);
GO

SELECT * FROM ModeraçãoConteudo

-- Tabela para Aplicar Penalidades (Painel do Administrador)
CREATE TABLE Penalidade (
	id					INT				IDENTITY(1,1),
	usuario_infrator_id	INT				NOT NULL,
	admin_id			INT				NOT NULL,
	tipo_penalidade		VARCHAR(30)		NOT NULL, -- Advertência, Suspensão, Banimento
	motivo				VARCHAR(MAX)	NOT NULL,
	data_inicio			DATETIME2		NOT NULL DEFAULT SYSDATETIME(),
	data_fim			DATETIME2			NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (usuario_infrator_id) REFERENCES Usuario (id),
	FOREIGN KEY (admin_id) REFERENCES Usuario (id),
	CONSTRAINT CK_Tipo_Penalidade CHECK (tipo_penalidade IN ('ADVERTENCIA', 'SUSPENSAO', 'BANIMENTO'))
);
GO

SELECT * FROM Penalidade

-- Tabela para Compartilhar e Favoritar Casos
CREATE TABLE Favorito (
	usuario_id			INT				NOT NULL,
	caso_id				INT				NOT NULL,
	data_favoritado		DATETIME2		NOT NULL DEFAULT SYSDATETIME(),

	PRIMARY KEY (usuario_id, caso_id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario (id),
	FOREIGN KEY (caso_id) REFERENCES Caso (id)
);
GO

SELECT * FROM Favorito

-- Tabela de Auditoria (Registrar Auditoria / Consultar Auditoria)
CREATE TABLE Auditoria (
	id					INT				IDENTITY(1,1),
	usuario_id			INT					NULL, -- Quem executou a ação (se autenticado)
	acao				VARCHAR(100)	NOT NULL,
	descricao			VARCHAR(MAX)		NULL,
	ip_origem			VARCHAR(45)			NULL,
	data_acao			DATETIME2		NOT NULL DEFAULT SYSDATETIME(),

	PRIMARY KEY (id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario (id)
);
GO

SELECT * FROM Auditoria