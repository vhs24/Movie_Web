import { Injectable } from '@angular/core';
import { ShowTime } from '../data/show-time';
import { Observable, of } from 'rxjs';
<<<<<<< HEAD:ng-movie-plus/src/app/view/service/ticket-service.service.ts
import { Movie } from 'src/app/common/data/movie-list';
=======
>>>>>>> parent of 9cf0149 (adding FE):ng-movie-plus/src/app/service/ticket-service.service.ts

@Injectable({
  providedIn: 'root',
})
export class TicketServiceService {
<<<<<<< HEAD:ng-movie-plus/src/app/view/service/ticket-service.service.ts
  constructor() {}
=======

  getData(): Observable<ShowTime> {
    return of().pipe()
  }

  constructor() { }
>>>>>>> parent of 9cf0149 (adding FE):ng-movie-plus/src/app/service/ticket-service.service.ts
}
