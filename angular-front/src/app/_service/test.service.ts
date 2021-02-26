import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Test} from "../_model/test";
import {TestParams} from "../_model/test-params";
import {Level} from "../_model/level";

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private _httpClient: HttpClient) {
  }

  getTestData(level: string): Observable<Test> {
    const href = '/api/test';
    return this._httpClient.post<Test>(href, new TestParams(level));
  }

  getLevels(): Observable<Level[]> {
    const href = '/api/test/levels';
    return this._httpClient.post<Level[]>(href, null);
  }
}
