class Api::V1::BooksController < Api::V1::BaseController
  before_action :set_book, only: [:update, :destroy]

  def index
    @books = Reviewer.first.books.paginate(page: params[:page], per_page: 10)
    render(
      json: @books.as_json(:include => :notes),
      status: 201
      )
  end


  def create
    @book = Reviewer.first.books.new(book_params)

      if @book.save
        render(
          json: @book.as_json,
          status: 201
          )
      else
        render json: @book.errors, status: :unprocessable_entity
      end
    
  end

  def update
      if @book.update(book_params)
        render :show, status: :ok, location: @book 
      else
        render json: @book.errors, status: :unprocessable_entity
      end
    
  end

  def destroy
    @book.destroy
    head :no_content    
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_book
      @book = Reviewer.first.books.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def book_params
      params.permit(:name, :author)
    end
  end
