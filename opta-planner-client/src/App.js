import { useState } from 'react';
import './App.css';
import optaPlanner_Logo from "./optaPlannerLogo.png";




function App() {

  const [lesson_subject, set_lesson_subject] = useState("")
  const [lesson_teacher, set_lesson_teacher] = useState("")
  const [lesson_studentGroup, set_lesson_studentGroup] = useState("")

  const [timeslot_startTime, set_timeslot_startTime] = useState("")
  const [timeslot_endTime, set_timeslot_endTime] = useState("")
  const [roomName, set_roomName] = useState("")



  return (
    <>

      <div className="container">
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <img src={optaPlanner_Logo} alt="OptaPlanner logo" href="https://www.optaplanner.org" />
        </nav>
        <div className="sticky-top d-flex justify-content-center align-items-center" aria-live="polite" aria-atomic="true">
          <div id="notificationPanel" style={{ position: "absolute", top: ".5rem" }}></div>
        </div>
        <h1>Class time table solver</h1>
        <p>Generate the optimal schedule for your teachers and students.</p>




        {/* <!-- REFRESH AND SOLVE BUTTONS  --> */}
        <div style={{ marginTop: ".5rem" }}>
          <button id="refreshButton" type="button" className="btn btn-secondary">
            <span className="fas fa-refresh"></span> Refresh
          </button>
          <button id="solveButton" type="button" className="btn btn-success">
            <span className="fas fa-play"></span> Solve
          </button>
          <button id="stopSolvingButton" type="button" className="btn btn-danger">
            <span className="fas fa-stop"></span> Stop solving
          </button>
          <span id="score" className="score ml-2 align-middle font-weight-bold">Score: ?</span>



          {/* <!-- SORTING BUTTONS --> */}
          <div className="float-end">
            <ul className="nav nav-pills" id="myTab" role="tablist">
              <li className="nav-item">
                <a className="nav-link active" id="byRoomTab" data-bs-toggle="tab" href="#byRoomPanel" role="tab"
                  aria-controls="byRoomPanel" aria-selected="true">By room</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" id="byTeacherTab" data-bs-toggle="tab" href="#byTeacher" role="tab"
                  aria-controls="byTeacher" aria-selected="false">By teacher</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" id="byStudentGroupTab" data-bs-toggle="tab" href="#byStudentGroup"
                  role="tab" aria-controls="byStudentGroup" aria-selected="false">By student group</a>
              </li>
            </ul>
          </div>
        </div>



        {/* <!-- SCHEDULE TABLE CONTENT  --> */}
        <div className="tab-content" id="myTabContent">
          <div className="tab-pane fade show active" id="byRoomPanel" role="tabpanel" aria-labelledby="byRoomTab">
            <table className="table table-borderless table-striped" id="timeTableByRoom">
              {/* <!-- Filled in by app.js --> */}
            </table>
          </div>
          <div className="tab-pane fade" id="byTeacher" role="tabpanel" aria-labelledby="byTeacherTab">
            <table className="table table-borderless table-striped" id="timeTableByTeacher">
              {/* <!-- Filled in by app.js --> */}
            </table>
          </div>
          <div className="tab-pane fade" id="byStudentGroup" role="tabpanel" aria-labelledby="byStudentGroupTab">
            <table className="table table-borderless table-striped" id="timeTableByStudentGroup">
              {/* <!-- Filled in by app.js --> */}
            </table>
          </div>
        </div>




        {/* <!-- CREATION BUTTONS --> */}
        <div>
          <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#lessonDialog">
            <span className="fas fa-plus"></span> Add lesson
          </button>
          <button type="button" className="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#timeslotDialog">
            <span className="fas fa-plus"></span> Add timeslot
          </button>
          <button type="button" className="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#roomDialog">
            <span className="fas fa-plus"></span> Add room
          </button>
        </div>


        {/* <!-- DISPLAY UNASSIGNED LESSONS --> */}
        <h2 style={{ marginTop: "2rem" }}>Unassigned lessons</h2>
        <div id="unassignedLessons" className="card-columns"></div>
      </div>


      {/* <!-- CREATION POP UPPS --> */}
      <div className="modal fade" id="lessonDialog" tabIndex="-1" role="dialog">
        <div className="modal-dialog" role="dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h4>Add a lesson</h4>
              <button type="button" className="close" data-bs-dismiss="modal">
                <span>&times;</span>
              </button>
            </div>
            <div className="modal-body">
              <div className="form-group">
                <label htmlFor="lesson_subject">Subject</label>
                <input type="text" className="form-control" id="lesson_subject" required value={lesson_subject} onChange={(e) => set_lesson_subject(e.target.value)} />
              </div>
              <div className="form-group">
                <label htmlFor="lesson_teacher">Teacher</label>
                <input type="text" className="form-control" id="lesson_teacher" required value={lesson_teacher} onChange={(e) => set_lesson_teacher(e.target.value)} />
              </div>
              <div className="form-group">
                <label htmlFor="lesson_studentGroup">Student group</label>
                <input type="text" className="form-control" id="lesson_studentGroup" required value={lesson_studentGroup} onChange={(e) => set_lesson_studentGroup(e.target.value)} />
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-default" data-bs-dismiss="modal">Cancel</button>
                <button type="button" className="btn btn-primary" id="addLessonSubmitButton">Submit new
                  lesson</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="modal fade" id="timeslotDialog" tabIndex="-1" role="dialog">
        <div className="modal-dialog" role="dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h4>Add a timeslot</h4>
              <button type="button" className="close" data-bs-dismiss="modal">
                <span>&times;</span>
              </button>
            </div>
            <div className="modal-body">
              <div className="form-group">
                <label htmlFor="timeslot_dayOfWeek">Day of week</label>
                <select className="form-control" id="timeslot_dayOfWeek" required>
                  <option>Monday</option>
                  <option>Tuesday</option>
                  <option>Wednesday</option>
                  <option>Thursday</option>
                  <option>Friday</option>
                  <option>Saturday</option>
                  <option>Sunday</option>
                </select>
              </div>
              <div className="form-group">
                <label htmlFor="timeslot_startTime">Start time</label>
                <input type="time" className="form-control" id="timeslot_startTime" required value={timeslot_startTime} onChange={(e) => set_timeslot_startTime(e.target.value)} />
              </div>
              <div className="form-group">
                <label htmlFor="timeslot_endTime">End time</label>
                <input type="time" className="form-control" id="timeslot_endTime" required value={timeslot_endTime} onChange={(e) => set_timeslot_endTime(e.target.value)} />
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-default" data-bs-dismiss="modal">Cancel</button>
                <button type="button" className="btn btn-primary" id="addTimeslotSubmitButton">Submit new timeslot
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="modal fade" id="roomDialog" tabIndex="-1" role="dialog">
        <div className="modal-dialog" role="dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h4>Add a room</h4>
              <button type="button" className="close" data-bs-dismiss="modal">
                <span>&times;</span>
              </button>
            </div>
            <div className="modal-body">
              <div className="form-group">
                <label htmlFor="room_name">Name</label>
                <input type="text" className="form-control" id="room_name" required value={roomName} onChange={(e) => set_roomName(e.target.value)} />
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-default" data-bs-dismiss="modal">Cancel</button>
                <button type="button" className="btn btn-primary" id="addRoomSubmitButton">Submit new room</button>
              </div>
            </div>
          </div>
        </div>
      </div>







      {/* <!-- IMPORTED SCRIPTS --> */}
      {/* <!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>  --> */}

      {/* <!-- moment.js --> */}
      <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>

      {/* <!-- fontawesome --> */}
      <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
        integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc"
        crossOrigin="anonymous"></script>

      {/* <!-- jquery --> */}
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

      {/* <!-- bootstrap --> */}
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossOrigin="anonymous"></script>

      <script src="./functionality.js"></script>


    </>
  );
}

export default App;
