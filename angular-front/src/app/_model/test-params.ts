export class TestParams {
  private _level:string;

  constructor(){
    this._level = '';
  }


  get level(): string {
    return this._level;
  }


  set level(value: string) {
    this._level = value;
  }
}
