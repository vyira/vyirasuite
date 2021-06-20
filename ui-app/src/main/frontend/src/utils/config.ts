interface IConfig {
  HOST: string;
  PORT: number;
  APP_NAME: string;
}

const UI_APP: IConfig = {
  PORT: 80,
  HOST: "localhost",
  APP_NAME: "ui-app",
};

const QUIZ_SERVER: IConfig = {
  PORT: 8090,
  HOST: "quiz-server",
  APP_NAME: "quiz-server",
};

const DISCOVERY_SERVER: IConfig = {
  HOST: "discovery-server",
  PORT: 8761,
  APP_NAME: "vyirasuite-discovery-server",
};

const RECRUITS: IConfig = {
  HOST: "recruits",
  PORT: 8091,
  APP_NAME: "vyirasuite-recruits",
};

export { QUIZ_SERVER, UI_APP, RECRUITS, DISCOVERY_SERVER };
