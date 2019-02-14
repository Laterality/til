/**
 * 요구사항
 * 
 * 로켓을 추상화한 Rocket 클래스를 작성한다.
 * Rocket 클래스는 적재물(Payload)과 발사 단계(Stage)의 배열을 갖는다.
 * 
 * 적재물은 중량(weight)을 갖는다.
 * 
 * 각 발사 단계에는 엔진(Engine) 배열이 들어가고, 엔진은 추진력(thrust)를 갖는다.
 */

 /**
  * 기본 클래스들 정의
  */
class Payload {
    constructor(
        private weight: number,
    ) { }
}

class Engine {
    constructor(
        private thrust: number,
    ) { }
}

class Stage {
    constructor(
        private engines: Engine[],
    ) { }
}

class Rocket {
    constructor(
        private payload: Payload,
        private stages: Stage[],
    ) { }
}


/**
 * 팩토리 메서드를 사용하지 않은 경우
 */
function buildRocket() {
    const payload = new Payload(0);
    const stage = [new Stage([new Engine(1000)])];
    const rocket = new Rocket(payload, stage);
    return rocket;
}

/**
 * 팩토리 메서드 패턴
 * 
 * Rocket 객체 생성에 필요한 다른 요소(component)들을 각각 별도의 메서드에서 생성하도록 분리
 */
class RocketFactory {
    buildRocket = (): Rocket => {
        const payload = this.createPayload();
        const stages = this.createStages();
        const rocket = new Rocket(payload, stages);

        return rocket;
    }

    createPayload = (): Payload => {
        return new Payload(0);
    }

    createStages = (): Stage[] => {
        const engine = new Engine(1000);
        const stage = new Stage([engine]);
        return [stage];
    }
}

/**
 * 추가 요구사항
 * 
 * 인공위성(Satellite)이 적재된 로켓 클래스(FreightRocket)를 작성한다.
 * 
 * 인공위성은 각각 고유한 id를 가진다.
 * 
 * 로켓의 발사 단계는 2단계로 나뉘며,
 * 1단계에서는 4개의 엔진을, 2단계에서는 1개의 엔진을 갖는다.
 */

/**
 * 기본 클래스로부터 상속
 */
class Satellite extends Payload {
    constructor(
        public id: number,
    ) {
        super(200);
    }
}

class FirstStage extends Stage {
    constructor() {
        super([
            new Engine(1000),
            new Engine(1000),
            new Engine(1000),
            new Engine(1000),
        ]);
    }
}

class SecondStage extends Stage {
    constructor() {
        super([new Engine(1000)]);
    }
}

type FreightRocketStages = [FirstStage, SecondStage];

/**
 * 팩토리 메서드를 사용하지 않은 경우
 * 
 * 기존 메서드(buildRocket)을 재사용할 수 없음
 */
function buildFreightRocket(id: number) {
    const payload = new Satellite(id);
    const stages = [
        new Stage([ // FirstStage
            new Engine(1000),
            new Engine(1000),
            new Engine(1000),
            new Engine(1000),
        ]),
        new Stage([ // SecondStage
            new Engine(1000),
        ])];
    const rocket = new Rocket(payload, stages);
    return rocket;
}

/**
 * 팩토리 메서드를 사용한 경우
 * 
 * 기존 팩토리 메서드(RocketFactory)를 상속하여 재사용
 * 덕분에 createRocket 메서드는 새로 정의할 필요 없음
 * 
 * 사용자에게 로켓 생성을 위한 일관된 인터페이스를 제공할 수 있음
 */
class FreightRocketFactory extends RocketFactory {
    private nextSatelliteId = 0;

    createPayload = (): Satellite => {
        return new Satellite(this.nextSatelliteId++);
    }

    createStages = (): FreightRocketStages => {
        return [
            new FirstStage(),
            new SecondStage(),
        ];
    }

}