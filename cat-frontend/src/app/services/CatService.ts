import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CatImage} from "../home/domain/CatImage";

@Injectable({
  providedIn: 'root'
})
export class CatService {

  private apiUrl = 'http://localhost:8080/api/cats';

  constructor(private http: HttpClient) {
  }

  getCatByTag(tag: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/tag`, {
      params: {tag: tag},
      responseType: 'arraybuffer',
    });
  }

  getCayByText(text: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/text`, {
      params: {text: text},
      responseType: 'arraybuffer',
    });
  }

  getCatByDimensions(width: number, height: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/dimensions`, {
      params: {width: width, height: height},
      responseType: 'arraybuffer',
    });
  }

  downloadCatImage(imageBytes: ArrayBuffer, subFolder: string, fileName: string): Observable<CatImage> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<CatImage>(`${this.apiUrl}/download`, imageBytes, {
      headers: headers,
      params: {subFolder, fileName},
    });
  }

}
