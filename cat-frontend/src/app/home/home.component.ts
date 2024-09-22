import {Component} from '@angular/core';
import {DomSanitizer, SafeUrl,} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {ChipsModule} from "primeng/chips";
import {CatService} from "../services/CatService";
import {KeycloakService} from "../services/keycloak/keycloak.service";

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  imports: [
    FormsModule,
    Button,
    NgIf,
    DialogModule,
    ChipsModule,
  ],
  providers: [CatService]
})
export class HomeComponent {

  tag: string;
  text: string;
  width: number;
  height: number;
  // catImage: string;
  catAlt: string;
  title: string;
  visible: boolean = false;
  fileName: string;
  catImageUrl: SafeUrl;
  catImageBlob: Blob;
  catImageByteArray: Uint8Array;
  folderName: string;
  imageArrayBuffer: ArrayBuffer;

  constructor(private catService: CatService, private sanitizer: DomSanitizer, private keycloakService: KeycloakService) {

  }

  async getCatByTag(): Promise<void> {
    this.catImageUrl = null;
    if (this.tag) {
      this.folderName = 'tag';
      this.title = `Get Cat With Tag: ${this.tag}`
      this.catService.getCatByTag(this.tag).subscribe(async res => {
          this.imageArrayBuffer = res;
          this.displayImage(res);
        },
        (error) => {
          alert(error.message)
        }
      );

    } else {
      alert("Please Enter Tag");
    }
  }

  getCatByText(): void {
    this.catImageUrl = null;
    if (this.text) {
      this.folderName = 'text';
      this.title = `Get Cat With Text: ${this.text}`
      this.catService.getCayByText(this.text).subscribe(res => {
          this.imageArrayBuffer = res;
          this.displayImage(res);
        },
        (error) => {
          alert(error.message)
        }
      );
    } else {
      alert("Please Enter Text");
    }
  }

  getCatByDimensions(): void {
    this.catImageUrl = null;
    if (this.width && this.height) {
      this.folderName = 'dimensions';
      this.title = `Get Cat Width: ${this.width}, Height: ${this.height}`
      this.catService.getCatByDimensions(this.width, this.height).subscribe(res => {
          this.imageArrayBuffer = res;
          this.displayImage(res);
        },
        (error) => {
          alert(error.message)
        }
      );
    } else {
      alert("Please Enter Dimensions");
    }
  }

  async downloadCatImage(): Promise<void> {
    if (this.imageArrayBuffer && this.fileName) {
      this.catService.downloadCatImage(this.imageArrayBuffer, this.folderName, this.fileName).subscribe(res => {
        if (res) {
          alert(`Downloaded ${res.fileName}.jpg ${res.filePath} to downloads folder`);
          this.visible = false;
        }
      }, error => {
        console.error('Error downloading cat image:', error);
      });
    } else {
      alert("Please Enter File Name");
    }

  }

  showDialog() {
    this.visible = true;
  }

  private displayImage(data: ArrayBuffer) {
    const blob = new Blob([data], {type: 'image/jpeg'});
    const imageUrl = URL.createObjectURL(blob);
    this.catImageUrl = this.sanitizer.bypassSecurityTrustUrl(imageUrl);
  }

  async logout() {
    this.keycloakService.logout()
  }

}
