import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TestData} from "../_model/test-data";
import {TestParams} from "../_model/test-params";

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private _httpClient: HttpClient) {
  }

  getTestData(level: string): Observable<TestData> {
    const href = '/api/test';
    return this._httpClient.post<TestData>(href, new TestParams(level));
  }
}
